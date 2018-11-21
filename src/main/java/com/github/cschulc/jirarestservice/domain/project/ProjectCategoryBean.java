package com.github.cschulc.jirarestservice.domain.project;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 30.06.2018
 * Time: 08:26
 */
public class ProjectCategoryBean extends BaseBean {

    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
