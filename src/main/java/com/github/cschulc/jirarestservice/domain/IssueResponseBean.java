package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class IssueResponseBean {

    @Expose
    private String key;
    @Expose
    private ErrorBean error = null;

    public IssueResponseBean() {
        super();
    }

    public IssueResponseBean(String key) {
        this.key = key;
    }

    public IssueResponseBean(ErrorBean error) {
        this.error = error;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }
}
