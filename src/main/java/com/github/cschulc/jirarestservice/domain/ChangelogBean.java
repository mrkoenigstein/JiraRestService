
package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class ChangelogBean {

    @Expose
    private Integer startAt;
    @Expose
    private Integer maxResults;
    @Expose
    private Integer total;
    @Expose
    private List<HistoryBean> histories = new ArrayList<>();

    public List<HistoryBean> getHistories() {
        return histories;
    }

    public void setHistories(List<HistoryBean> histories) {
        this.histories = histories;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public Integer getStartAt() {
        return startAt;
    }

    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
