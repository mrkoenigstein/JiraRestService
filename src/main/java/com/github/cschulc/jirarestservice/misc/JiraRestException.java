package com.github.cschulc.jirarestservice.misc;

import com.github.cschulc.jirarestservice.domain.Error;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JiraRestException extends Exception{

    private int statusCode;

    private String reasonPhrase;

    private Error restErrorMessage;

    public JiraRestException(int statusCode, String reasonPhrase, Error restErrorMessage) {
        super(statusCode + " " + reasonPhrase + " " + restErrorMessage);
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
        this.restErrorMessage = restErrorMessage;
    }

    public JiraRestException(CloseableHttpResponse response) throws IOException {
        StatusLine statusLine = response.getStatusLine();
        this.statusCode = statusLine.getStatusCode();
        this.reasonPhrase = statusLine.getReasonPhrase();
        try {
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            if(inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
                JsonReader jsonReader = new JsonReader(reader);
                jsonReader.setLenient(true);
                Gson gson = new Gson();
                restErrorMessage = gson.fromJson(jsonReader, Error.class);
            }
        } catch (IOException e) {
            // nothing to say
        } finally {
            response.close();
        }

    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public Error getRestErrorMessage() {
        return restErrorMessage;
    }

    public void setRestErrorMessage(Error restErrorMessage) {
        this.restErrorMessage = restErrorMessage;
    }
}
