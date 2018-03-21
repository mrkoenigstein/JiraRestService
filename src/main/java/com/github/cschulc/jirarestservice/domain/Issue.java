package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Issue extends Base {

    @Expose
    private Fields fields;
    @Expose
    private String key;
    @Expose
    private RenderedFields renderedFields;
    @Expose
    private List<Transition> transitions;
    @Expose
    private Changelog changelog;

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RenderedFields getRenderedFields() {
        return renderedFields;
    }

    public void setRenderedFields(RenderedFields renderedFields) {
        this.renderedFields = renderedFields;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public Changelog getChangelog() {
        return changelog;
    }

    public void setChangelog(Changelog changelog) {
        this.changelog = changelog;
    }
}
