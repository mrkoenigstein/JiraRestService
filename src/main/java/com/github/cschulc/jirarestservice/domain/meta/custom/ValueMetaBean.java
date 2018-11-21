package com.github.cschulc.jirarestservice.domain.meta.custom;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ValueMetaBean extends BaseBean {

    @Expose
    private String value;

    @Expose
    private List<ValueMetaBean> children = new ArrayList<>();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ValueMetaBean> getChildren() {
        return children;
    }

    public void setChildren(List<ValueMetaBean> children) {
        this.children = children;
    }
}
