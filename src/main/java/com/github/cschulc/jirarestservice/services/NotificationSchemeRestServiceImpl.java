package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.notification.NotificationSchemeBean;
import com.github.cschulc.jirarestservice.domain.notification.NotifictaionSchemesBean;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.utils.URIBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


import static com.github.cschulc.jirarestservice.misc.RestParams.*;
import static com.github.cschulc.jirarestservice.misc.RestPaths.*;
/**
 * @author Christian Schulze
 */
public class NotificationSchemeRestServiceImpl extends BaseRestService implements NotificationSchemeRestService {

    public NotificationSchemeRestServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }


    @Override
    public Future<NotifictaionSchemesBean> getNotificationSchemes(int startAt, int maxResults, String expand) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(NOTIFICATION_SCHEME);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                NotifictaionSchemesBean notifictaionSchemes = gson.fromJson(jsonReader, NotifictaionSchemesBean.class);
                restApiCall.release();
                return notifictaionSchemes;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<NotificationSchemeBean> getNotificationScheme(String id, String expand) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(NOTIFICATION_SCHEME, id);
            uriBuilder.addParameter(EXPAND, expand);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                NotificationSchemeBean notifictaionSchemes = gson.fromJson(jsonReader, NotificationSchemeBean.class);
                restApiCall.release();
                return notifictaionSchemes;
            } else {
                throw restApiCall.buildException();
            }
        });
    }
}
