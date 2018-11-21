package com.github.cschulc.jirarestservice.domain.notification;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class NotificationSchemeEventBean {

    @Expose
    private EventBean event;

    @Expose
    private List<NotificationBean> notifications = new ArrayList<>();

    public EventBean getEvent() {
        return event;
    }

    public void setEvent(EventBean event) {
        this.event = event;
    }

    public List<NotificationBean> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationBean> notifications) {
        this.notifications = notifications;
    }
}
