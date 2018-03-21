package com.github.cschulc.jirarestservice.domain.meta.custom;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ValueMeta extends Base {

    @Expose
    private String value;

    @Expose
    private List<ValueMeta> children = new ArrayList<>();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ValueMeta> getChildren() {
        return children;
    }

    public void setChildren(List<ValueMeta> children) {
        this.children = children;
    }
}
