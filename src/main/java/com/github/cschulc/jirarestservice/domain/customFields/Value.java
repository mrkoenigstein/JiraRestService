package com.github.cschulc.jirarestservice.domain.customFields;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

public class Value extends Base {

    @Expose
    private String value;

    @Expose
    private Value child;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Value getChild() {
        return child;
    }

    public void setChild(Value child) {
        this.child = child;
    }
}
