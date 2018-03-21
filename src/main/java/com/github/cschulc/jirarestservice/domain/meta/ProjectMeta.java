package com.github.cschulc.jirarestservice.domain.meta;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ProjectMeta extends Base {

    @Expose
    private String key;

    @Expose
    private List<IssueTypeMeta> issuetypes = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<IssueTypeMeta> getIssuetypes() {
        return issuetypes;
    }

    public void setIssuetypes(List<IssueTypeMeta> issuetypes) {
        this.issuetypes = issuetypes;
    }
}
