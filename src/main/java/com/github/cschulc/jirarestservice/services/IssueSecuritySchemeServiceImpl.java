package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.security.IssueSecurityScheme;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemes;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.utils.URIBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 09:00
 */
public class IssueSecuritySchemeServiceImpl extends BaseService implements IssueSecuritySchemeService {


    public IssueSecuritySchemeServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    @Override
    public Future<IssueSecuritySchemes> getIssueSecuritySchemes() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUESECURITYSCHEMES);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                JsonReader jsonReader = restApiCall.getJsonReader();
                IssueSecuritySchemes issueSecuritySchemes = gson.fromJson(jsonReader, IssueSecuritySchemes.class);
                restApiCall.release();
                return issueSecuritySchemes;
            }
            else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<IssueSecurityScheme> getIssueSecurityScheme(String id) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUESECURITYSCHEMES, id);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                JsonReader jsonReader = restApiCall.getJsonReader();
                IssueSecurityScheme issueSecurityScheme = gson.fromJson(jsonReader, IssueSecurityScheme.class);
                restApiCall.release();
                return issueSecurityScheme;
            }
            else {
                throw restApiCall.buildException();
            }
        });
    }
}
