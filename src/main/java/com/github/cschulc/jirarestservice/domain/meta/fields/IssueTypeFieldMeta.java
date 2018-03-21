package com.github.cschulc.jirarestservice.domain.meta.fields;

import com.github.cschulc.jirarestservice.domain.Issuetype;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class IssueTypeFieldMeta extends FieldMeta {

    @Expose
    private List<Issuetype> allowedValues = new ArrayList<>();

    public List<Issuetype> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<Issuetype> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
