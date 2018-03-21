package com.github.cschulc.jirarestservice.domain.meta;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Meta extends Base {

    @Expose
    private List<ProjectMeta> projects = new ArrayList<>();

    public List<ProjectMeta> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectMeta> projects) {
        this.projects = projects;
    }
}
