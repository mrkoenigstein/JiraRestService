package com.github.cschulc.jirarestservice.domain.user;

import com.github.cschulc.jirarestservice.domain.BaseJson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 26.06.2018
 * Time: 13:30
 */
public class UserResult extends BaseJson {

    @Expose
    private int maxResults;

    @Expose
    private int startAt;

    @Expose
    private int total;

    @Expose
    private boolean isLast;

    @Expose
    @SerializedName("values")
    private List<User> users = new ArrayList<>();

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getStartAt() {
        return startAt;
    }

    public void setStartAt(int startAt) {
        this.startAt = startAt;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
