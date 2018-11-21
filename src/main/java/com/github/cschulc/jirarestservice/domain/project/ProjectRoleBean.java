package com.github.cschulc.jirarestservice.domain.project;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.github.cschulc.jirarestservice.domain.notification.ActorBean;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class ProjectRoleBean extends BaseBean {

    @Expose
    private String description = StringUtils.EMPTY;

    @Expose
    private List<ActorBean> actors = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ActorBean> getActors() {
        return actors;
    }

    public void setActors(List<ActorBean> actors) {
        this.actors = actors;
    }
}
