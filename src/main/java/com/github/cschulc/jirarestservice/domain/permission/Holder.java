package com.github.cschulc.jirarestservice.domain.permission;

import com.github.cschulc.jirarestservice.domain.BaseJson;
import com.github.cschulc.jirarestservice.domain.project.ProjectRole;
import com.google.gson.annotations.Expose;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 12:49
 */
public class Holder extends BaseJson {

    @Expose
    private String type;

    @Expose
    private String parameter;

    @Expose
    private String expand;

    @Expose
    private ProjectRole projectRole;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public ProjectRole getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(ProjectRole projectRole) {
        this.projectRole = projectRole;
    }
}
