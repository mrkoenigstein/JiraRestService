package com.github.cschulc.jirarestservice.domain.project;

import com.github.cschulc.jirarestservice.domain.Base;
import com.github.cschulc.jirarestservice.domain.notification.Actor;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class ProjectRole extends Base {

    @Expose
    private String description = StringUtils.EMPTY;

    @Expose
    private List<Actor> actors = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
