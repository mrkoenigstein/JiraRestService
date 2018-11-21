package com.github.cschulc.jirarestservice.domain.meta;

import com.github.cschulc.jirarestservice.domain.IssuetypeBean;
import com.google.gson.annotations.Expose;

public class IssueTypeMetaBean extends IssuetypeBean {

    @Expose
    private FieldsMetaBean fields;

    public FieldsMetaBean getFields() {
        return fields;
    }

    public void setFields(FieldsMetaBean fields) {
        this.fields = fields;
    }
}
