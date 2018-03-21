package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.JqlSearchResult;
import com.github.cschulc.jirarestservice.domain.filter.Filter;
import com.github.cschulc.jirarestservice.jql.SearchBean;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang3.Validate;
import org.apache.http.client.utils.URIBuilder;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SearchServiceImpl extends BaseService implements SearchService {

    public SearchServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    public Future<JqlSearchResult> searchIssues(final SearchBean jsb) {
        Validate.notNull(jsb);
        return executorService.submit(() -> {
            String body = gson.toJson(jsb);
            URIBuilder uriBuilder = buildPath(SEARCH);
            RestApiCall restApiCall = doPost(uriBuilder.build(), body);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                JqlSearchResult jqlSearchResult = gson.fromJson(jsonReader, JqlSearchResult.class);
                restApiCall.release();
                return jqlSearchResult;
            } else {
                throw restApiCall.buildException();
            }
        });

    }


    public Future<Filter> createSearchFilter(Filter create) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FILTER);
            RestApiCall restApiCall = doPost(uriBuilder.build(), create.toString());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Filter filter = gson.fromJson(jsonReader, Filter.class);
                restApiCall.release();
                return filter;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<Filter>> getFavoriteFilter() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FILTER, FAVORITE);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<Filter>>() {
                }.getType();
                List<Filter> filters = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return filters;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<Filter> getFilterById(String id) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(FILTER, id);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Filter filter = gson.fromJson(jsonReader, Filter.class);
                restApiCall.release();
                return filter;
            } else {
                throw restApiCall.buildException();
            }
        });
    }
}
