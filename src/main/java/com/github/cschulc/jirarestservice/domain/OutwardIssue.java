package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class OutwardIssue {

    @Expose
    private String id;
    @Expose
    private String key;
    @Expose
    private String self;
    @Expose
    private OutwardIssueFields fields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public OutwardIssueFields getFields() {
        return fields;
    }

    public void setFields(OutwardIssueFields fields) {
        this.fields = fields;
    }
}
