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
import com.github.cschulc.jirarestservice.domain.groups.GroupBean;
import com.github.cschulc.jirarestservice.domain.groups.GroupUsersBean;
import com.github.cschulc.jirarestservice.domain.groups.GroupsBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.utils.URIBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static com.github.cschulc.jirarestservice.misc.RestParams.*;
import static com.github.cschulc.jirarestservice.misc.RestPaths.*;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 26.06.2018
 * Time: 09:26
 */
public class GroupRestServiceImpl extends BaseRestService implements GroupRestService {

    public GroupRestServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    @Override
    public Future<GroupsBean> findGroups(String query, String exclude, int maxResults, String username) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(GROUPS, PICKER);
            checkAndAddStringParameter(uriBuilder, query, QUERY);
            checkAndAddStringParameter(uriBuilder, exclude, EXCLUDE);
            checkAndAddIntParameter(uriBuilder, maxResults, MAX_RESULTS);
            checkAndAddStringParameter(uriBuilder, username, USER_NAME);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                final GroupsBean groups = gson.fromJson(jsonReader,
                        GroupsBean.class);
                restApiCall.release();
                return groups;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<GroupBean> addUserToGroup(String groupname, String username) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(GROUP, USER);
            uriBuilder.addParameter(GROUPNAME, groupname);
            UserBean user = new UserBean();
            user.setName(username);
            RestApiCall restApiCall = doPost(uriBuilder.build(), user.toString());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                final GroupBean groups = gson.fromJson(jsonReader,
                        GroupBean.class);
                restApiCall.release();
                return groups;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<GroupUsersBean> getUsersFromGroup(String groupname, boolean includeInactiveUsers, int startAt, int maxResults) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(GROUP, MEMBER);
            checkAndAddStringParameter(uriBuilder, groupname, GROUPNAME);
            checkAndAddBooleanParameter(uriBuilder, includeInactiveUsers, INCLUDEINACTIVEUSERS);
            checkAndAddIntParameter(uriBuilder, maxResults, MAX_RESULTS);
            checkAndAddIntParameter(uriBuilder, startAt, START_AT);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                final GroupUsersBean groups = gson.fromJson(jsonReader,
                        GroupUsersBean.class);
                restApiCall.release();
                return groups;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

}
