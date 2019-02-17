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
import com.github.cschulc.jirarestservice.domain.AttachmentMetaBean;
import com.github.cschulc.jirarestservice.domain.IssuetypeBean;
import com.github.cschulc.jirarestservice.domain.PriorityBean;
import com.github.cschulc.jirarestservice.domain.StatusBean;
import com.github.cschulc.jirarestservice.domain.avatar.AvatarType;
import com.github.cschulc.jirarestservice.domain.avatar.SystemAvatarsBean;
import com.github.cschulc.jirarestservice.domain.field.CreateFieldBean;
import com.github.cschulc.jirarestservice.domain.field.FieldBean;
import com.github.cschulc.jirarestservice.domain.system.ConfigurationBean;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.utils.URIBuilder;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static com.github.cschulc.jirarestservice.misc.RestPaths.AVATAR;
import static com.github.cschulc.jirarestservice.misc.RestPaths.CONFIGURATION;
import static com.github.cschulc.jirarestservice.misc.RestPaths.FIELD;
import static com.github.cschulc.jirarestservice.misc.RestPaths.ISSUETPYES;
import static com.github.cschulc.jirarestservice.misc.RestPaths.PRIORITY;
import static com.github.cschulc.jirarestservice.misc.RestPaths.STATUS;
import static com.github.cschulc.jirarestservice.misc.RestPaths.SYSTEM;

public class SystemRestServiceImpl extends BaseRestService implements SystemRestService {


    public SystemRestServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    @Override
    public Future<ConfigurationBean> getConfiguration() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(CONFIGURATION);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                ConfigurationBean configuration = gson.fromJson(jsonReader, ConfigurationBean.class);
                restApiCall.release();
                return configuration;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    public Future<List<IssuetypeBean>> getIssueTypes() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUETPYES);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<IssuetypeBean>>() {
                }.getType();
                List<IssuetypeBean> issuetypes = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return issuetypes;
            } else {
                throw restApiCall.buildException();
            }
        });

    }


    public Future<List<StatusBean>> getStates() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(STATUS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<StatusBean>>() {
                }.getType();
                List<StatusBean> states = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return states;
            } else {
                throw restApiCall.buildException();
            }
        });

    }


    public Future<List<PriorityBean>> getPriorities() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PRIORITY);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<PriorityBean>>() {
                }.getType();
                List<PriorityBean> priorities = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return priorities;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<FieldBean>> getAllFields() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FIELD);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<FieldBean>>() {
                }.getType();
                List<FieldBean> fields = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return fields;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<FieldBean>> getAllCustomFields() {
        return executorService.submit(() -> {
            List<FieldBean> retval = new ArrayList<>();
            Future<List<FieldBean>> allFields = getAllFields();
            List<FieldBean> fieldBeen = allFields.get();
            for (FieldBean fieldBean : fieldBeen) {
                if (fieldBean.getCustom()) {
                    retval.add(fieldBean);
                }
            }
            return retval;
        });
    }


    public Future<FieldBean> getCustomFieldById(final String id) {
        return executorService.submit(() -> {
            Future<List<FieldBean>> allFields = getAllFields();
            List<FieldBean> fieldBeen = allFields.get();
            for (FieldBean fieldBean : fieldBeen) {
                if (!fieldBean.getCustom()) {
                    continue;
                }
                if (fieldBean.getId().contains(id)) {
                    return fieldBean;
                }
            }
            return null;
        });
    }


    public Future<AttachmentMetaBean> getAttachmentMeta() {
        return null;
    }

    @Override
    public Future<FieldBean> createCustomField(CreateFieldBean customField) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FIELD);
            RestApiCall restApiCall = doPost(uriBuilder.build(), customField.toString());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_CREATED) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                FieldBean fieldBean = gson.fromJson(jsonReader, FieldBean.class);
                restApiCall.release();
                return fieldBean;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<SystemAvatarsBean> getAllSystemAvatars(AvatarType avatarType) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(AVATAR, avatarType.getName(), SYSTEM);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                JsonReader jsonReader = restApiCall.getJsonReader();
                SystemAvatarsBean systemAvatars = gson.fromJson(jsonReader, SystemAvatarsBean.class);
                restApiCall.release();
                return systemAvatars;
            }else {
                throw restApiCall.buildException();
            }
        });
    }
}
