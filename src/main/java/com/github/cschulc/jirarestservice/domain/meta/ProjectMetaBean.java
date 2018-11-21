package com.github.cschulc.jirarestservice.domain.meta;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ProjectMetaBean extends BaseBean {

    @Expose
    private String key;

    @Expose
    private List<IssueTypeMetaBean> issuetypes = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<IssueTypeMetaBean> getIssuetypes() {
        return issuetypes;
    }

    public void setIssuetypes(List<IssueTypeMetaBean> issuetypes) {
        this.issuetypes = issuetypes;
    }
}
