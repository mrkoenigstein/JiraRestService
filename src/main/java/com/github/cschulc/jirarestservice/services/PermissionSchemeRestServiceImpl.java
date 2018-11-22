package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.permission.PermissionSchemeBean;
import com.github.cschulc.jirarestservice.domain.permission.PermissionSchemesBean;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.utils.URIBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class PermissionSchemeRestServiceImpl extends BaseRestService implements PermissionSchemeRestService {

    public PermissionSchemeRestServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    @Override
    public Future<PermissionSchemesBean> getPermissionsSchemes() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(PERMISSION_SCHEME);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                PermissionSchemesBean permissionScheme = gson.fromJson(jsonReader, PermissionSchemesBean.class);
                restApiCall.release();
                return permissionScheme;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<PermissionSchemeBean> getPermissionScheme(String id) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(PERMISSION_SCHEME, id);
            uriBuilder.addParameter(EXPAND, "all");
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                PermissionSchemeBean permissionScheme = gson.fromJson(jsonReader, PermissionSchemeBean.class);
                restApiCall.release();
                return permissionScheme;
            } else {
                throw restApiCall.buildException();
            }
        });
    }
}
