package com.github.cschulc.jirarestservice.domain.notification;

import com.github.cschulc.jirarestservice.domain.BaseJson;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Christian Schulze
 */
public class Event extends BaseJson {

    @Expose
    private String description = StringUtils.EMPTY;

    @Expose
    private Event templateEvent;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event getTemplateEvent() {
        return templateEvent;
    }

    public void setTemplateEvent(Event templateEvent) {
        this.templateEvent = templateEvent;
    }
}
