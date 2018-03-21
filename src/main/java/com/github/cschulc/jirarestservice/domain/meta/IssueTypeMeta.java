package com.github.cschulc.jirarestservice.domain.meta;

import com.github.cschulc.jirarestservice.domain.Issuetype;
import com.google.gson.annotations.Expose;

public class IssueTypeMeta extends Issuetype {

    @Expose
    private FieldsMeta fields;

    public FieldsMeta getFields() {
        return fields;
    }

    public void setFields(FieldsMeta fields) {
        this.fields = fields;
    }
}
