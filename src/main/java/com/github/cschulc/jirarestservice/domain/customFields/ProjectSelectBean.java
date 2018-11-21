package com.github.cschulc.jirarestservice.domain.customFields;

import com.github.cschulc.jirarestservice.domain.ProjectBean;

public class ProjectSelectBean extends CustomFieldBaseBean {

    private ProjectBean project;

    public ProjectBean getProject() {
        return project;
    }

    public void setProject(ProjectBean project) {
        this.project = project;
    }
}
