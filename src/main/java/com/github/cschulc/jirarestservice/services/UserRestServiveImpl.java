/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

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


import static com.github.cschulc.jirarestservice.misc.RestParams.*;
import static com.github.cschulc.jirarestservice.misc.RestPaths.*;

public class UserRestServiveImpl extends BaseRestService implements UserRestService {

    public UserRestServiveImpl(JiraRestService service, ExecutorService executorService) {
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
            } else if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED || statusCode == HttpURLConnection.HTTP_FORBIDDEN || statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
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
            checkAndAddBooleanParameter(uriBuilder, includeActive, INCLUDE_ACTIVE);
            checkAndAddBooleanParameter(uriBuilder, includeInactive, INCLUDE_INACTIVE);
            checkAndAddIntParameter(uriBuilder, maxResults, MAX_RESULTS);
            checkAndAddStringParameter(uriBuilder, property, PROPERTY);
            checkAndAddStringParameter(uriBuilder, username, USERNAME);
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
            checkAndAddStringParameter(uriBuilder, username, USERNAME);
            checkAndAddStringParameter(uriBuilder, issueKey, ISSUEKEY);
            checkAndAddStringParameter(uriBuilder, projectKey, PROJECTKEY);
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
