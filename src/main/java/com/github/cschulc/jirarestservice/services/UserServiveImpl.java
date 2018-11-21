package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.permission.MyPermissionsBean;
import com.github.cschulc.jirarestservice.domain.user.CreateUserBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.github.cschulc.jirarestservice.misc.Experimental;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
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

    public Future<List<UserBean>> getAssignableUserForProject(String projectKey, Integer startAt, Integer maxResults) {
        return getAssignableSearch(null, null, projectKey, startAt, maxResults);
    }


    public Future<List<UserBean>> getAssignableUsersForIssue(String issueKey, Integer startAt, Integer maxResults) {
        return getAssignableSearch(null, issueKey, null, startAt, maxResults);
    }


    public Future<UserBean> getUserByUsername(final String username) {
        Validate.notNull(username);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(USER);
            uriBuilder.addParameter(USERNAME, username);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                UserBean user = gson.fromJson(jsonReader, UserBean.class);
                restApiCall.release();
                return user;
            } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                return null;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<UserBean> getLoggedInRemoteUser() {
        String username = restService.getUsername();
        return getUserByUsername(username);
    }

    @Override
    public Future<MyPermissionsBean> getMyPermissions() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(MYPERMISSIONS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                MyPermissionsBean permissionsBean = gson.fromJson(jsonReader, MyPermissionsBean.class);
                restApiCall.release();
                return permissionsBean;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    @Experimental
    public Future<UserBean> createUser(CreateUserBean createUser) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(USER);
            String body = createUser.toString();
            RestApiCall restApiCall = doPost(uriBuilder.build(), body);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_CREATED) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                UserBean user = gson.fromJson(jsonReader, UserBean.class);
                restApiCall.release();
                return user;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<List<UserBean>> findUsers(boolean includeActive, boolean includeInactive, int maxResults, String property, int startAt, String username) {
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
                return getUserListFromJson(restApiCall);
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    private Future<List<UserBean>> getAssignableSearch(final String username, final String issueKey, final String projectKey, final Integer startAt, final Integer maxResults) {
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
                return getUserListFromJson(restApiCall);
            } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                return new ArrayList<>();
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    private List<UserBean> getUserListFromJson(RestApiCall restApiCall) throws IOException {
        JsonReader jsonReader = restApiCall.getJsonReader();
        Type listType = new TypeToken<ArrayList<UserBean>>() {
        }.getType();
        List<UserBean> users = gson.fromJson(jsonReader, listType);
        restApiCall.release();
        return users;
    }
}
