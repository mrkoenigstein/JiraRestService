package com.github.cschulc.jirarestservice.domain.groups;

import com.github.cschulc.jirarestservice.domain.BaseJsonBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;

import java.util.*;

/**
 * @author Christian Schulze
 */
public class GroupBean extends BaseJsonBean {

    @Expose
    private String name;

    @Expose
    private String html;

    @Expose
    private List<UserBean> users = new ArrayList<>();

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

    public List<UserBean> getUsers() {
        return users;
    }
}
