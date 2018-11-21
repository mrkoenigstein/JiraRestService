package com.github.cschulc.jirarestservice.domain.user;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 21.06.2018
 * Time: 12:42
 */
public class CreateUserBean extends UserBean {

    @Expose
    private String password;

    @Expose
    private String notification;

    @Expose
    private List<String> applicationKeys = new ArrayList<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public List<String> getApplicationKeys() {
        return applicationKeys;
    }

    public void setApplicationKeys(List<String> applicationKeys) {
        this.applicationKeys = applicationKeys;
    }
}
