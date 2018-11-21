package com.github.cschulc.jirarestservice.domain.field;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

public class CreateFieldBean extends BaseBean {

    @Expose
    private String description;

    @Expose
    private String type;

    @Expose
    private String searcherKey;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSearcherKey() {
        return searcherKey;
    }

    public void setSearcherKey(String searcherKey) {
        this.searcherKey = searcherKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
