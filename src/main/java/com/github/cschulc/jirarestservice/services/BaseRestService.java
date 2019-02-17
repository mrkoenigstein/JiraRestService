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
import com.github.cschulc.jirarestservice.domain.IssueBean;
import com.github.cschulc.jirarestservice.domain.meta.MetaBean;
import com.github.cschulc.jirarestservice.gson.IssueDeserializer;
import com.github.cschulc.jirarestservice.gson.MetaDeserializer;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.github.cschulc.jirarestservice.util.URIHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpMessage;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutorService;

public abstract class BaseRestService {

    protected JiraRestService restService;
    protected final CloseableHttpClient client;
    protected final HttpClientContext context;
    protected final URI baseUri;
    protected ExecutorService executorService;

    protected final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .registerTypeAdapter(IssueBean.class, new IssueDeserializer())
            .registerTypeAdapter(MetaBean.class, new MetaDeserializer())
            .create();

    public BaseRestService(JiraRestService restService) {
        this.restService = restService;
        this.client = restService.getClient();
        this.context = restService.getContext();
        this.baseUri = restService.getBaseUri();
    }

    public RestApiCall doGet(URI uri) throws IOException {
        HttpGet httpGet = createGetMethod(uri);
        RestApiCall call = new RestApiCall(httpGet);
        call.execute(client, context);
        return call;
    }

    public RestApiCall doPost(URI uri, String body) throws IOException {
        HttpPost httpPost = createPostMethod(uri, body);
        RestApiCall apiCall = new RestApiCall(httpPost);
        apiCall.execute(client, context);
        return apiCall;
    }

    public RestApiCall doPostForFile(URI uri, HttpEntity entity) throws IOException {
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setHeader("X-Atlassian-Token", "no-check");
        httpPost.setEntity(entity);
        RestApiCall apiCall = new RestApiCall(httpPost);
        apiCall.execute(client, context);
        return apiCall;
    }

    public RestApiCall doPut(URI uri, String body) throws IOException {
        HttpPut httpPut = createPutMethod(uri, body);
        RestApiCall apiCall = new RestApiCall(httpPut);
        apiCall.execute(client, context);
        return apiCall;
    }

    public RestApiCall doGetForFile(URI uri) throws IOException {
        HttpGet httpGet = createHttpGetForFile(uri);
        RestApiCall call = new RestApiCall(httpGet);
        call.execute(client, context);
        return call;
    }

    protected URIBuilder buildPath(String... paths) {
        return URIHelper.buildPath(baseUri, paths);
    }

    private HttpGet createGetMethod(URI uri) {
        if (uri == null) return null;
        HttpGet method = new HttpGet(uri);
        setHeader(method);
        configProxy(method);
        return method;
    }


    private HttpGet createHttpGetForFile(URI uri) {
        if (uri == null) return null;
        HttpGet method = new HttpGet(uri);
        configProxy(method);
        method.addHeader(HttpHeaders.ACCEPT,
                MediaType.APPLICATION_OCTET_STREAM);
        return method;
    }

    private HttpPost createPostMethod(URI uri, String body) {
        if (uri == null) return null;
        HttpPost method = new HttpPost(uri);
        return (HttpPost) addHeaderProxyAndBody(body, method);
    }



    private HttpPut createPutMethod(URI uri, String body) {
        if (uri == null) return null;
        HttpPut method = new HttpPut(uri);
        return (HttpPut) addHeaderProxyAndBody(body, method);
    }

    private void setHeader(HttpMessage httpMessage) {
        httpMessage.addHeader(new BasicHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON));
        httpMessage.addHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
    }

    private void configProxy(HttpRequestBase method) {
        RequestConfig requestConfig = restService.getConfig();
        if (requestConfig != null) {
            method.setConfig(requestConfig);
        }
    }

    private HttpEntityEnclosingRequestBase addHeaderProxyAndBody(String body, HttpEntityEnclosingRequestBase method) {
        setHeader(method);
        configProxy(method);
        StringEntity entity = new StringEntity(body, CharEncoding.UTF_8);
        method.setEntity(entity);
        return method;
    }

    protected void checkAndAddStringParameter(URIBuilder uriBuilder, String value, String parameterName) {
        if (StringUtils.trimToNull(value) != null) {
            uriBuilder.addParameter(parameterName, value);
        }
    }

    protected void checkAndAddBooleanParameter(URIBuilder uriBuilder, boolean value, String parameter) {
        if (value) {
            uriBuilder.addParameter(parameter, String.valueOf(true));
        }
    }

    protected void checkAndAddIntParameter(URIBuilder uriBuilder, int value, String parameter) {
        if (value > 0) {
            uriBuilder.addParameter(parameter, String.valueOf(value));
        }
    }
}
