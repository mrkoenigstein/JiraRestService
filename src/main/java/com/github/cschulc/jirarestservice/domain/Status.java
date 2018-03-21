package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class Status extends Base {

    @Expose
    private String description;
    @Expose
    private String iconUrl;
    @Expose
    private StatusCategory statusCategory;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public StatusCategory getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(StatusCategory statusCategory) {
        this.statusCategory = statusCategory;
    }
}
