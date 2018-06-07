package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.notification.NotificationScheme;
import com.github.cschulc.jirarestservice.domain.notification.NotifictaionSchemes;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.utils.URIBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class NotificationSchemeServiceImpl extends BaseService implements NotificationSchemeService {

    public NotificationSchemeServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }


    @Override
    public Future<NotifictaionSchemes> getNotificationSchemes(int startAt, int maxResults, String expand) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(NOTIFICATION_SCHEME);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                NotifictaionSchemes notifictaionSchemes = gson.fromJson(jsonReader, NotifictaionSchemes.class);
                restApiCall.release();
                return notifictaionSchemes;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<NotificationScheme> getNotificationScheme(String id, String expand) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(NOTIFICATION_SCHEME, id);
            uriBuilder.addParameter(EXPAND, expand);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                NotificationScheme notifictaionSchemes = gson.fromJson(jsonReader, NotificationScheme.class);
                restApiCall.release();
                return notifictaionSchemes;
            } else {
                throw restApiCall.buildException();
            }
        });
    }
}
