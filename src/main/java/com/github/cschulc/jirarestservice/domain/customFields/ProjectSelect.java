package com.github.cschulc.jirarestservice.domain.customFields;

import com.github.cschulc.jirarestservice.domain.Project;

public class ProjectSelect extends CustomFieldBase {

    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
