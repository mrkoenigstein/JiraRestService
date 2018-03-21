package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;


public class Priority extends Base {

    @Expose
    private String iconUrl;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

}
