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

package com.github.cschulc.jirarestservice.util;

import com.github.cschulc.jirarestservice.misc.JiraRestException;
import com.google.gson.stream.JsonReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

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

    private JsonReader getJsonReader(InputStream inputStream) {
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true);
        return jsonReader;
    }

    /**
     * For debug use only
     *
     * @return The Content of the Request Body as String
     * @throws IOException
     */
    public String getAsString() throws IOException {
        String text = EntityUtils.toString(response.getEntity());
        EntityUtils.consume(response.getEntity());
        return text;
    }

    public HttpRequestBase getMethod() {
        return method;
    }

    public CloseableHttpResponse getResponse() {
        return response;
    }
}
