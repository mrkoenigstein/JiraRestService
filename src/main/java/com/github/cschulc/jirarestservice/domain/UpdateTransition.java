package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class UpdateTransition extends Base {

    @Expose
    private Transition transition;

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }
}
