package com.github.cschulc.jirarestservice.domain.update;

import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueUpdateBean {

    @Expose
    private Map<String, Object> fields = new HashMap<>();
    @Expose
    private Map<String, List<FieldOperationBean>> update = new HashMap<>();

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }

    public Map<String, List<FieldOperationBean>> getUpdate() {
        return update;
    }

    public void setUpdate(Map<String, List<FieldOperationBean>> update) {
        this.update = update;
    }
}
