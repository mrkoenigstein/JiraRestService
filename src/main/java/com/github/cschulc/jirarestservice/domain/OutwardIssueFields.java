package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class OutwardIssueFields {

    @Expose
    private String summary;
    @Expose
    private Status status;
    @Expose
    private Priority priority;
    @Expose
    private Issuetype issuetype;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Issuetype getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }
}
