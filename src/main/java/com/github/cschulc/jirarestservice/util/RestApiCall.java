package com.github.cschulc.jirarestservice.util;

import com.github.cschulc.jirarestservice.misc.JiraRestException;
import com.google.gson.stream.JsonReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class RestApiCall {

    private HttpRequestBase method;

    private CloseableHttpResponse response;

    public RestApiCall(HttpRequestBase method) {
        this.method = method;
    }

    public void execute(CloseableHttpClient client, HttpClientContext context) throws IOException {
        response = client.execute(method, context);
    }

    public int getStatusCode(){
        return response.getStatusLine().getStatusCode();
    }

    public void release() throws IOException {
        method.releaseConnection();
        response.close();
    }

    public HttpEntity getHttpEntity(){
        return response.getEntity();
    }

    public JsonReader getJsonReader() throws IOException {
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent();
        return getJsonReader(inputStream);
    }

    public JiraRestException buildException() throws IOException {
        JiraRestException exception = new JiraRestException(response);
        release();
        return exception;
    }

    private JsonReader getJsonReader(InputStream inputStream)
            throws UnsupportedEncodingException {
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true);
        return jsonReader;
    }

    public HttpRequestBase getMethod() {
        return method;
    }

    public CloseableHttpResponse getResponse() {
        return response;
    }
}
