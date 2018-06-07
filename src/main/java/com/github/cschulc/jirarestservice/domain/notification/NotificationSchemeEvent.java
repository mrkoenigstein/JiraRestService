package com.github.cschulc.jirarestservice.domain.notification;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class NotificationSchemeEvent {

    @Expose
    private Event event;

    @Expose
    private List<Notification> notifications = new ArrayList<>();

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
