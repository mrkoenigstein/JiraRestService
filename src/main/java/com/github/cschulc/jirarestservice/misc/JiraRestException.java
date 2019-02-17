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

package com.github.cschulc.jirarestservice.misc;

import com.github.cschulc.jirarestservice.domain.ErrorBean;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JiraRestException extends Exception {

    private final int statusCode;

    private final String reasonPhrase;

    private final ErrorBean restErrorMessage;

    public JiraRestException(CloseableHttpResponse response) throws IOException {
        StatusLine statusLine = response.getStatusLine();
        this.statusCode = statusLine.getStatusCode();
        this.reasonPhrase = statusLine.getReasonPhrase();
        this.restErrorMessage = getErrorsFromResponse(response);
    }

    private ErrorBean getErrorsFromResponse(CloseableHttpResponse response) throws IOException {
        try {
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            if (inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                JsonReader jsonReader = new JsonReader(reader);
                jsonReader.setLenient(true);
                Gson gson = new Gson();
                return gson.fromJson(jsonReader, ErrorBean.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
        return null;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public ErrorBean getRestErrorMessage() {
        return restErrorMessage;
    }
}
