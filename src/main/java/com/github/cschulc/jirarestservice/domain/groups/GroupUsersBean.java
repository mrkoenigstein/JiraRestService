package com.github.cschulc.jirarestservice.domain.groups;

import com.github.cschulc.jirarestservice.domain.BaseJsonBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Christian Schulze (christian.schulze@iee.fraunhofer.de)
 * Date: 14.01.2019
 */
public class GroupUsersBean extends BaseJsonBean {

    @Expose
    private String self;
    @Expose
    private long maxResults;
    @Expose
    private long startAt;
    @Expose
    private long total;
    @Expose
    private boolean isLast;
    @Expose
    @SerializedName("values")
    private List<UserBean> users = new ArrayList<>();

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public long getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(long maxResults) {
        this.maxResults = maxResults;
    }

    public long getStartAt() {
        return startAt;
    }

    public void setStartAt(long startAt) {
        this.startAt = startAt;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }
}
