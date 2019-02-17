
/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.cschulc.jirarestservice.domain.filter;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Objects;

public class FilterBean extends BaseBean {

    @Expose
    private String description;
    @Expose
    private UserBean owner;
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
    private SharedUsersBean sharedUsers;
    @Expose
    private SubscriptionsBean subscriptions;

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

    public UserBean getOwner() {
        return owner;
    }

    public void setOwner(UserBean owner) {
        this.owner = owner;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public SharedUsersBean getSharedUsers() {
        return sharedUsers;
    }

    public void setSharedUsers(SharedUsersBean sharedUsers) {
        this.sharedUsers = sharedUsers;
    }

    public List<Object> getSharePermissions() {
        return sharePermissions;
    }

    public void setSharePermissions(List<Object> sharePermissions) {
        this.sharePermissions = sharePermissions;
    }

    public SubscriptionsBean getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(SubscriptionsBean subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilterBean)) return false;
        if (!super.equals(o)) return false;
        FilterBean that = (FilterBean) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(jql, that.jql) &&
                Objects.equals(viewUrl, that.viewUrl) &&
                Objects.equals(searchUrl, that.searchUrl) &&
                Objects.equals(favourite, that.favourite) &&
                Objects.equals(sharePermissions, that.sharePermissions) &&
                Objects.equals(sharedUsers, that.sharedUsers) &&
                Objects.equals(subscriptions, that.subscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, owner, jql, viewUrl, searchUrl, favourite, sharePermissions, sharedUsers, subscriptions);
    }
}
