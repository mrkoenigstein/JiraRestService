package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class ComponentBean extends BaseBean {

    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
