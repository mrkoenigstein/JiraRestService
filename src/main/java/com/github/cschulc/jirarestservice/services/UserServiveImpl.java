package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.user.CreateUser;
import com.github.cschulc.jirarestservice.domain.user.User;
import com.github.cschulc.jirarestservice.domain.permission.MyPermissions;
import com.github.cschulc.jirarestservice.domain.user.UserResult;
import com.github.cschulc.jirarestservice.misc.Experimental;
import com.github.cschulc.jirarestservice.misc.JiraRestException;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.http.client.utils.URIBuilder;

import java.lang.reflect.Type;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class UserServiveImpl extends BaseService implements UserService {

    public UserServiveImpl(JiraRestService service, ExecutorService executorService) {
        super(service);
        this.executorService = executorService;
    }

    public Future<List<User>> getAssignableUserForProject(String projectKey, Integer startAt, Integer maxResults) {
        return getAssignableSearch(null, null, projectKey, startAt, maxResults);
    }


    public Future<List<User>> getAssignableUsersForIssue(String issueKey, Integer startAt, Integer maxResults) {
        return getAssignableSearch(null, issueKey, null, startAt, maxResults);
    }


    public Future<User> getUserByUsername(final String username) {
        Validate.notNull(username);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(USER);
            uriBuilder.addParameter(USERNAME, username);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                User user = gson.fromJson(jsonReader, User.class);
                restApiCall.release();
                return user;
            } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                return null;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<User> getLoggedInRemoteUser() {
        String username = restService.getUsername();
        return getUserByUsername(username);
    }

    @Override
    public Future<MyPermissions> getMyPermissions() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(MYPERMISSIONS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                MyPermissions permissionsBean = gson.fromJson(jsonReader, MyPermissions.class);
                restApiCall.release();
                return permissionsBean;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    @Experimental
    public Future<User> createUser(CreateUser createUser) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(USER);
            String body = createUser.toString();
            RestApiCall restApiCall = doPost(uriBuilder.build(), body);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_CREATED) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                User user = gson.fromJson(jsonReader, User.class);
                restApiCall.release();
                return user;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<List<User>> findUsers(boolean includeActive, boolean includeInactive, int maxResults, String property, int startAt, String username) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(USER, SEARCH);
            if (includeActive == true) {
                uriBuilder.addParameter(INCLUDE_ACTIVE, String.valueOf(includeActive));
            }
            if (includeInactive == true) {
                uriBuilder.addParameter(INCLUDE_INACTIVE, String.valueOf(includeInactive));
            }
            if (maxResults > 0) {
                uriBuilder.addParameter(MAX_RESULTS, String.valueOf(maxResults));
            }
            if (StringUtils.trimToNull(property) != null) {
                uriBuilder.addParameter(PROPERTY, property);
            }
            if (StringUtils.trimToNull(username) != null) {
                uriBuilder.addParameter(USERNAME, username);
            }
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<User>>() {
                }.getType();
                List<User> users = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return users;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    private Future<List<User>> getAssignableSearch(final String username, final String issueKey, final String projectKey, final Integer startAt, final Integer maxResults) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(USER, ASSIGNABLE, SEARCH);
            if (StringUtils.trimToNull(username) != null) {
                uriBuilder.addParameter(USERNAME, username);
            }
            if (StringUtils.trimToNull(issueKey) != null) {
                uriBuilder.addParameter(ISSUEKEY, issueKey);
            }
            if (StringUtils.trimToNull(projectKey) != null) {
                uriBuilder.addParameter(PROJECTKEY, projectKey);
            }
            if (startAt != null && startAt >= 0) {
                uriBuilder.addParameter(START_AT, startAt.toString());
            }
            if (maxResults != null && maxResults > 0 && maxResults < 1000) {
                uriBuilder.addParameter(MAX_RESULTS, maxResults.toString());
            }
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<User>>() {
                }.getType();
                List<User> users = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return users;
            } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                return new ArrayList<>();
            } else {
                throw restApiCall.buildException();
            }
        });
    }
}
