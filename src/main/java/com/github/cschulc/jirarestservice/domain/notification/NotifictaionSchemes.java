package com.github.cschulc.jirarestservice.domain.notification;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class NotifictaionSchemes {

    @Expose
    private String maxResults = StringUtils.EMPTY;

    @Expose
    private int startAt;

    @Expose
    private int total;

    @Expose
    private boolean isLast;

    @Expose
    private List<NotificationScheme> values = new ArrayList<>();

    public String getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(String maxResults) {
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

    public List<NotificationScheme> getValues() {
        return values;
    }

    public void setValues(List<NotificationScheme> values) {
        this.values = values;
    }
}
