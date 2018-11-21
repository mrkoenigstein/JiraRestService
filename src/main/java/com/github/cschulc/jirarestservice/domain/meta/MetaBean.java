package com.github.cschulc.jirarestservice.domain.meta;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class MetaBean extends BaseBean {

    @Expose
    private List<ProjectMetaBean> projects = new ArrayList<>();

    public List<ProjectMetaBean> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectMetaBean> projects) {
        this.projects = projects;
    }
}
