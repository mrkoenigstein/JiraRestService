package com.github.cschulc.jirarestservice.domain;

import com.github.cschulc.jirarestservice.domain.customFields.CustomFieldBase;
import com.github.cschulc.jirarestservice.domain.user.User;
import com.google.gson.annotations.Expose;

import java.util.List;

public class Fields {

    @Expose
    private Aggregateprogress aggregateprogress;
    @Expose
    private Integer aggregatetimeestimate;
    @Expose
    private Integer aggregatetimeoriginalestimate;
    @Expose
    private Integer aggregatetimespent;
    @Expose
    private User assignee;
    @Expose
    private List<Attachment> attachment;
    @Expose
    private Comments comment;
    @Expose
    private List<Component> components;
    @Expose
    private String created;
    @Expose
    private User creator;
    @Expose
    private String description;
    @Expose
    private String duedate;
    @Expose
    private String environment;
    @Expose
    private List<Version> fixVersions;
    @Expose
    private List<Issuelink> issuelinks;
    @Expose
    private Issuetype issuetype;
    @Expose
    private Issue parent;
    @Expose
    private List<String> labels;
    @Expose
    private String lastViewed;
    @Expose
    private Priority priority;
    @Expose
    private Progress progress;
    @Expose
    private Project project;
    @Expose
    private User reporter;
    @Expose
    private Resolution resolution;
    @Expose
    private String resolutiondate;
    @Expose
    private Status status;
    @Expose
    private List<Issue> subtasks;
    @Expose
    private String summary;
    @Expose
    private Integer timeestimate;
    @Expose
    private Integer timeoriginalestimate;
    @Expose
    private Integer timespent;
    @Expose
    private TimeTracking timetracking;
    @Expose
    private String updated;
    @Expose
    private List<Version> versions;
    @Expose
    private VotesBean votes;
    @Expose
    private Watches watches;
    @Expose
    private Worklog worklog;
    @Expose
    private Integer workratio;

    private List<CustomFieldBase> customFields;

    public Aggregateprogress getAggregateprogress() {
        return aggregateprogress;
    }

    public void setAggregateprogress(Aggregateprogress aggregateprogress) {
        this.aggregateprogress = aggregateprogress;
    }

    public Integer getAggregatetimeestimate() {
        return aggregatetimeestimate;
    }

    public void setAggregatetimeestimate(Integer aggregatetimeestimate) {
        this.aggregatetimeestimate = aggregatetimeestimate;
    }

    public Integer getAggregatetimeoriginalestimate() {
        return aggregatetimeoriginalestimate;
    }

    public void setAggregatetimeoriginalestimate(Integer aggregatetimeoriginalestimate) {
        this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
    }

    public Integer getAggregatetimespent() {
        return aggregatetimespent;
    }

    public void setAggregatetimespent(Integer aggregatetimespent) {
        this.aggregatetimespent = aggregatetimespent;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public List<Version> getFixVersions() {
        return fixVersions;
    }

    public void setFixVersions(List<Version> fixVersions) {
        this.fixVersions = fixVersions;
    }

    public List<Issuelink> getIssuelinks() {
        return issuelinks;
    }

    public void setIssuelinks(List<Issuelink> issuelinks) {
        this.issuelinks = issuelinks;
    }

    public Issuetype getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }

    public Issue getParent() {
        return parent;
    }

    public void setParent(Issue parent) {
        this.parent = parent;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getLastViewed() {
        return lastViewed;
    }

    public void setLastViewed(String lastViewed) {
        this.lastViewed = lastViewed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public String getResolutiondate() {
        return resolutiondate;
    }

    public void setResolutiondate(String resolutiondate) {
        this.resolutiondate = resolutiondate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Issue> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Issue> subtasks) {
        this.subtasks = subtasks;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getTimeestimate() {
        return timeestimate;
    }

    public void setTimeestimate(Integer timeestimate) {
        this.timeestimate = timeestimate;
    }

    public Integer getTimeoriginalestimate() {
        return timeoriginalestimate;
    }

    public void setTimeoriginalestimate(Integer timeoriginalestimate) {
        this.timeoriginalestimate = timeoriginalestimate;
    }

    public Integer getTimespent() {
        return timespent;
    }

    public void setTimespent(Integer timespent) {
        this.timespent = timespent;
    }

    public TimeTracking getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(TimeTracking timetracking) {
        this.timetracking = timetracking;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    public VotesBean getVotes() {
        return votes;
    }

    public void setVotes(VotesBean votes) {
        this.votes = votes;
    }

    public Watches getWatches() {
        return watches;
    }

    public void setWatches(Watches watches) {
        this.watches = watches;
    }

    public Worklog getWorklog() {
        return worklog;
    }

    public void setWorklog(Worklog worklog) {
        this.worklog = worklog;
    }

    public Integer getWorkratio() {
        return workratio;
    }

    public void setWorkratio(Integer workratio) {
        this.workratio = workratio;
    }

    public List<CustomFieldBase> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomFieldBase> customFields) {
        this.customFields = customFields;
    }
}