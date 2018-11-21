package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class UpdateTransitionBean extends BaseBean {

    @Expose
    private TransitionBean transition;

    public TransitionBean getTransition() {
        return transition;
    }

    public void setTransition(TransitionBean transition) {
        this.transition = transition;
    }
}
