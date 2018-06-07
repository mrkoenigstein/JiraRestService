package com.github.cschulc.jirarestservice.domain.notification;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class NotificationScheme extends Base {

    @Expose
    private String description = StringUtils.EMPTY;

    @Expose
    private List<NotificationSchemeEvent> notificationSchemeEvents = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<NotificationSchemeEvent> getNotificationSchemeEvents() {
        return notificationSchemeEvents;
    }

    public void setNotificationSchemeEvents(List<NotificationSchemeEvent> notificationSchemeEvents) {
        this.notificationSchemeEvents = notificationSchemeEvents;
    }
}
