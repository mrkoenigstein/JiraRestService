package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

/**
 * Author: Christian
 * Date: 09.12.2014.
 */
public class TransitionBean extends BaseBean {

    @Expose
    private StatusBean to;

    public StatusBean getTo() {
        return to;
    }

    public void setTo(StatusBean to) {
        this.to = to;
    }
}
