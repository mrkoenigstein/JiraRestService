package com.github.cschulc.jirarestservice.domain.project;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 30.06.2018
 * Time: 08:26
 */
public class ProjectCategory extends Base {

    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
