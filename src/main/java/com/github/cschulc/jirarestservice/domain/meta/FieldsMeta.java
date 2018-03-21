package com.github.cschulc.jirarestservice.domain.meta;

import com.github.cschulc.jirarestservice.domain.meta.fields.*;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class FieldsMeta {

    @Expose
    private IssueTypeFieldMeta issuetype;

    @Expose
    private ComponentFieldMeta components;

    @Expose
    private FieldMeta description;

    @Expose
    private ProjectFieldMeta project;

    @Expose
    private VersionsFieldMeta fixVersions;

    @Expose
    private FieldMeta timetracking;

    @Expose
    private FieldMeta attachment;

    @Expose
    private FieldMeta summary;

    @Expose
    private FieldMeta reporter;

    @Expose
    private PriorityFieldMeta priority;

    @Expose
    private FieldMeta labels;

    @Expose
    private FieldMeta environment;

    @Expose
    private VersionsFieldMeta versions;

    @Expose
    private FieldMeta duedate;

    @Expose
    private FieldMeta assignee;

    private List<FieldMeta> custom = new ArrayList<>();

    public IssueTypeFieldMeta getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssueTypeFieldMeta issuetype) {
        this.issuetype = issuetype;
    }

    public ComponentFieldMeta getComponents() {
        return components;
    }

    public void setComponents(ComponentFieldMeta components) {
        this.components = components;
    }

    public FieldMeta getDescription() {
        return description;
    }

    public void setDescription(FieldMeta description) {
        this.description = description;
    }

    public ProjectFieldMeta getProject() {
        return project;
    }

    public void setProject(ProjectFieldMeta project) {
        this.project = project;
    }

    public VersionsFieldMeta getFixVersions() {
        return fixVersions;
    }

    public void setFixVersions(VersionsFieldMeta fixVersions) {
        this.fixVersions = fixVersions;
    }

    public FieldMeta getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(FieldMeta timetracking) {
        this.timetracking = timetracking;
    }

    public FieldMeta getAttachment() {
        return attachment;
    }

    public void setAttachment(FieldMeta attachment) {
        this.attachment = attachment;
    }

    public FieldMeta getSummary() {
        return summary;
    }

    public void setSummary(FieldMeta summary) {
        this.summary = summary;
    }

    public FieldMeta getReporter() {
        return reporter;
    }

    public void setReporter(FieldMeta reporter) {
        this.reporter = reporter;
    }

    public PriorityFieldMeta getPriority() {
        return priority;
    }

    public void setPriority(PriorityFieldMeta priority) {
        this.priority = priority;
    }

    public FieldMeta getLabels() {
        return labels;
    }

    public void setLabels(FieldMeta labels) {
        this.labels = labels;
    }

    public FieldMeta getEnvironment() {
        return environment;
    }

    public void setEnvironment(FieldMeta environment) {
        this.environment = environment;
    }

    public VersionsFieldMeta getVersions() {
        return versions;
    }

    public void setVersions(VersionsFieldMeta versions) {
        this.versions = versions;
    }

    public FieldMeta getDuedate() {
        return duedate;
    }

    public void setDuedate(FieldMeta duedate) {
        this.duedate = duedate;
    }

    public FieldMeta getAssignee() {
        return assignee;
    }

    public void setAssignee(FieldMeta assignee) {
        this.assignee = assignee;
    }

    public List<FieldMeta> getCustom() {
        return custom;
    }

    public void setCustom(List<FieldMeta> custom) {
        this.custom = custom;
    }
}
