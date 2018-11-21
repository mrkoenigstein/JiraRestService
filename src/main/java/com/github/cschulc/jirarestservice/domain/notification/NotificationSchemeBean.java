package com.github.cschulc.jirarestservice.domain.notification;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class NotificationSchemeBean extends BaseBean {

    @Expose
    private String description = StringUtils.EMPTY;

    @Expose
    private List<NotificationSchemeEventBean> notificationSchemeEvents = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<NotificationSchemeEventBean> getNotificationSchemeEvents() {
        return notificationSchemeEvents;
    }

    public void setNotificationSchemeEvents(List<NotificationSchemeEventBean> notificationSchemeEvents) {
        this.notificationSchemeEvents = notificationSchemeEvents;
    }
}
