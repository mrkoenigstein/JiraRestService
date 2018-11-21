package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.IssueBean;
import com.github.cschulc.jirarestservice.domain.meta.MetaBean;
import com.github.cschulc.jirarestservice.gson.IssueDeserializer;
import com.github.cschulc.jirarestservice.gson.MetaDeserializer;
import com.github.cschulc.jirarestservice.misc.RestParams;
import com.github.cschulc.jirarestservice.misc.RestPaths;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.github.cschulc.jirarestservice.util.URIHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.CharEncoding;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpMessage;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutorService;

public abstract class BaseService implements RestPaths, RestParams {

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

    public BaseService(JiraRestService restService) {
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
        setHeader(method);
        configProxy(method);
        StringEntity entity = new StringEntity(body, CharEncoding.UTF_8);
        method.setEntity(entity);
        return method;
    }

    private HttpPut createPutMethod(URI uri, String body) {
        if (uri == null) return null;
        HttpPut method = new HttpPut(uri);
        setHeader(method);
        configProxy(method);
        StringEntity entity = new StringEntity(body, CharEncoding.UTF_8);
        method.setEntity(entity);
        return method;
    }

    private void setHeader(HttpMessage httpMessage) {
        httpMessage.addHeader(new BasicHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON));
        httpMessage.addHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
    }

    private void configProxy(HttpRequestBase method) {
        RequestConfig requestConfig = JiraRestService.getConfig();
        if (requestConfig != null) {
            method.setConfig(requestConfig);
        }
    }
}
