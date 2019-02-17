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
