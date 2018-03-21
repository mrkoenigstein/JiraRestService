package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class IssueResponse  {

    @Expose
    private String key;
    @Expose
    private Error error = null;

    public IssueResponse() {
        super();
    }

    public IssueResponse(String key) {
        this.key = key;
    }

    public IssueResponse(Error error) {
        this.error = error;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
