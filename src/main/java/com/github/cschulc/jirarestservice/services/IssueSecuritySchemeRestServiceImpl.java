package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemeBean;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemesBean;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.utils.URIBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 09:00
 */
public class IssueSecuritySchemeRestServiceImpl extends BaseRestService implements IssueSecuritySchemeRestService {


    public IssueSecuritySchemeRestServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    @Override
    public Future<IssueSecuritySchemesBean> getIssueSecuritySchemes() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUESECURITYSCHEMES);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                JsonReader jsonReader = restApiCall.getJsonReader();
                IssueSecuritySchemesBean issueSecuritySchemes = gson.fromJson(jsonReader, IssueSecuritySchemesBean.class);
                restApiCall.release();
                return issueSecuritySchemes;
            }
            else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<IssueSecuritySchemeBean> getIssueSecurityScheme(String id) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUESECURITYSCHEMES, id);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                JsonReader jsonReader = restApiCall.getJsonReader();
                IssueSecuritySchemeBean issueSecurityScheme = gson.fromJson(jsonReader, IssueSecuritySchemeBean.class);
                restApiCall.release();
                return issueSecurityScheme;
            }
            else {
                throw restApiCall.buildException();
            }
        });
    }
}
