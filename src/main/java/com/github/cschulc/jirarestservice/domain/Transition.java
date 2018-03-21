package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

/**
 * Author: Christian
 * Date: 09.12.2014.
 */
public class Transition extends Base {

    @Expose
    private Status to;

    public Status getTo() {
        return to;
    }

    public void setTo(Status to) {
        this.to = to;
    }
}
