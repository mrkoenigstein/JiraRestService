package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class Issuelink {

    @Expose
    private String id;
    @Expose
    private String self;
    @Expose
    private Type type;
    @Expose
    private OutwardIssue outwardIssue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public OutwardIssue getOutwardIssue() {
        return outwardIssue;
    }

    public void setOutwardIssue(OutwardIssue outwardIssue) {
        this.outwardIssue = outwardIssue;
    }
}
