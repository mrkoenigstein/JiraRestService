package com.github.cschulc.jirarestservice.domain.customFields;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

public class ValueBean extends BaseBean {

    @Expose
    private String value;

    @Expose
    private ValueBean child;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ValueBean getChild() {
        return child;
    }

    public void setChild(ValueBean child) {
        this.child = child;
    }
}
