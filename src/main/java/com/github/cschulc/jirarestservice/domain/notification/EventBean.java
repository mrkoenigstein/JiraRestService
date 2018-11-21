package com.github.cschulc.jirarestservice.domain.notification;

import com.github.cschulc.jirarestservice.domain.BaseJsonBean;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Christian Schulze
 */
public class EventBean extends BaseJsonBean {

    @Expose
    private String description = StringUtils.EMPTY;

    @Expose
    private EventBean templateEvent;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventBean getTemplateEvent() {
        return templateEvent;
    }

    public void setTemplateEvent(EventBean templateEvent) {
        this.templateEvent = templateEvent;
    }
}
