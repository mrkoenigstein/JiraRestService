package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.AttachmentMeta;
import com.github.cschulc.jirarestservice.domain.Issuetype;
import com.github.cschulc.jirarestservice.domain.Priority;
import com.github.cschulc.jirarestservice.domain.Status;
import com.github.cschulc.jirarestservice.domain.avatar.AvatarType;
import com.github.cschulc.jirarestservice.domain.avatar.SystemAvatars;
import com.github.cschulc.jirarestservice.domain.field.CreateField;
import com.github.cschulc.jirarestservice.domain.field.Field;
import com.github.cschulc.jirarestservice.domain.system.Configuration;
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

public class SystemServiceImpl extends BaseService implements SystemService {


    public SystemServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    @Override
    public Future<Configuration> getConfiguration() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(CONFIGURATION);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Configuration configuration = gson.fromJson(jsonReader, Configuration.class);
                restApiCall.release();
                return configuration;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    public Future<List<Issuetype>> getIssueTypes() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUETPYES);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<Issuetype>>() {
                }.getType();
                List<Issuetype> issuetypes = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return issuetypes;
            } else {
                throw restApiCall.buildException();
            }
        });

    }


    public Future<List<Status>> getStates() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(STATUS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<Status>>() {
                }.getType();
                List<Status> states = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return states;
            } else {
                throw restApiCall.buildException();
            }
        });

    }


    public Future<List<Priority>> getPriorities() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PRIORITY);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<Priority>>() {
                }.getType();
                List<Priority> priorities = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return priorities;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<Field>> getAllFields() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FIELD);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<Field>>() {
                }.getType();
                List<Field> fields = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return fields;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<Field>> getAllCustomFields() {
        return executorService.submit(() -> {
            List<Field> retval = new ArrayList<>();
            Future<List<Field>> allFields = getAllFields();
            List<Field> fieldBeen = allFields.get();
            for (Field fieldBean : fieldBeen) {
                if (fieldBean.getCustom() == true) {
                    retval.add(fieldBean);
                }
            }
            return retval;
        });
    }


    public Future<Field> getCustomFieldById(final String id) {
        return executorService.submit(() -> {
            Future<List<Field>> allFields = getAllFields();
            List<Field> fieldBeen = allFields.get();
            for (Field fieldBean : fieldBeen) {
                if (fieldBean.getCustom() == false) {
                    continue;
                }
                if (fieldBean.getId().contains(id) == true) {
                    return fieldBean;
                }
            }
            return null;
        });
    }


    public Future<AttachmentMeta> getAttachmentMeta() {
        return null;
    }

    @Override
    public Future<Field> createCustomField(CreateField customField) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FIELD);
            RestApiCall restApiCall = doPost(uriBuilder.build(), customField.toString());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_CREATED) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Field fieldBean = gson.fromJson(jsonReader, Field.class);
                restApiCall.release();
                return fieldBean;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<SystemAvatars> getAllSystemAvatars(AvatarType avatarType) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(AVATAR, avatarType.getName(), SYSTEM);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                JsonReader jsonReader = restApiCall.getJsonReader();
                SystemAvatars systemAvatars = gson.fromJson(jsonReader, SystemAvatars.class);
                restApiCall.release();
                return systemAvatars;
            }else {
                throw restApiCall.buildException();
            }
        });
    }
}
