
package com.github.cschulc.jirarestservice.domain.filter;

import com.github.cschulc.jirarestservice.domain.Base;
import com.github.cschulc.jirarestservice.domain.user.User;
import com.google.gson.annotations.Expose;

import java.util.List;

public class Filter extends Base {

    @Expose
    private String description;
    @Expose
    private User owner;
    @Expose
    private String jql;
    @Expose
    private String viewUrl;
    @Expose
    private String searchUrl;
    @Expose
    private Boolean favourite;
    @Expose
    private List<Object> sharePermissions;
    @Expose
    private SharedUsers sharedUsers;
    @Expose
    private Subscriptions subscriptions;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public String getJql() {
        return jql;
    }

    public void setJql(String jql) {
        this.jql = jql;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public SharedUsers getSharedUsers() {
        return sharedUsers;
    }

    public void setSharedUsers(SharedUsers sharedUsers) {
        this.sharedUsers = sharedUsers;
    }

    public List<Object> getSharePermissions() {
        return sharePermissions;
    }

    public void setSharePermissions(List<Object> sharePermissions) {
        this.sharePermissions = sharePermissions;
    }

    public Subscriptions getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Subscriptions subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }
}
