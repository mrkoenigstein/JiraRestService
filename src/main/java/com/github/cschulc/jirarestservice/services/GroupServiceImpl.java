package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.groups.Group;
import com.github.cschulc.jirarestservice.domain.groups.Groups;
import com.github.cschulc.jirarestservice.domain.user.User;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 26.06.2018
 * Time: 09:26
 */
public class GroupServiceImpl extends BaseService implements GroupService {

    public GroupServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    @Override
    public Future<Groups> getGroups(String query, String exclude, int maxResults, String username) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(GROUPS, PICKER);
            if (StringUtils.trimToNull(query) != null) {
                uriBuilder.addParameter(QUERY, query);
            }
            if (StringUtils.trimToNull(exclude) != null) {
                uriBuilder.addParameter(EXCLUDE, exclude);
            }
            if (maxResults > 0) {
                uriBuilder.addParameter(MAX_RESULTS, String.valueOf(maxResults));
            }
            if (StringUtils.trimToNull(username) != null) {
                uriBuilder.addParameter(USER_NAME, username);
            }
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                final Groups groups = gson.fromJson(jsonReader,
                        Groups.class);
                restApiCall.release();
                return groups;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Group> addUserToGroup(String groupname, String username) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(GROUP, USER);
            uriBuilder.addParameter(GROUPNAME, groupname);
            User user = new User();
            user.setName(username);
            RestApiCall restApiCall = doPost(uriBuilder.build(), user.toString());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                final Group groups = gson.fromJson(jsonReader,
                        Group.class);
                restApiCall.release();
                return groups;
            } else {
                throw restApiCall.buildException();
            }
        });
    }
}
