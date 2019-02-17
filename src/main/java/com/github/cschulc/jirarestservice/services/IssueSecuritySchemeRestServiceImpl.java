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
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemeBean;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemesBean;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.utils.URIBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static com.github.cschulc.jirarestservice.misc.RestPaths.ISSUESECURITYSCHEMES;
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
