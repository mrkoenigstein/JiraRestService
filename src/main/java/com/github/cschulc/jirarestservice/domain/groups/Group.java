package com.github.cschulc.jirarestservice.domain.groups;

import com.github.cschulc.jirarestservice.domain.BaseJson;
import com.github.cschulc.jirarestservice.domain.user.User;
import com.google.gson.annotations.Expose;

import java.util.*;

/**
 * @author Christian Schulze
 */
public class Group extends BaseJson {

    @Expose
    private String name;

    @Expose
    private String html;

    @Expose
    private List<User> users = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<User> getUsers() {
        return users;
    }
}
