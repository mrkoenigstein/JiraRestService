/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.cschulc.jirarestservice.domain;

import com.github.cschulc.jirarestservice.domain.custom.CustomFieldBaseBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Objects;

public class FieldsBean {

    @Expose
    private AggregateProgressBean aggregateprogress;
    @Expose
    private Integer aggregatetimeestimate;
    @Expose
    private Integer aggregatetimeoriginalestimate;
    @Expose
    private Integer aggregatetimespent;
    @Expose
    private UserBean assignee;
    @Expose
    private List<AttachmentBean> attachment;
    @Expose
    private CommentsBean comment;
    @Expose
    private List<ComponentBean> components;
    @Expose
    private String created;
    @Expose
    private UserBean creator;
    @Expose
    private String description;
    @Expose
    private String duedate;
    @Expose
    private String environment;
    @Expose
    private List<VersionBean> fixVersions;
    @Expose
    private List<IssuelinkBean> issuelinks;
    @Expose
    private IssuetypeBean issuetype;
    @Expose
    private IssueBean parent;
    @Expose
    private List<String> labels;
    @Expose
    private String lastViewed;
    @Expose
    private PriorityBean priority;
    @Expose
    private ProgressBean progress;
    @Expose
    private ProjectBean project;
    @Expose
    private UserBean reporter;
    @Expose
    private ResolutionBean resolution;
    @Expose
    private String resolutiondate;
    @Expose
    private StatusBean status;
    @Expose
    private List<IssueBean> subtasks;
    @Expose
    private String summary;
    @Expose
    private Integer timeestimate;
    @Expose
    private Integer timeoriginalestimate;
    @Expose
    private Integer timespent;
    @Expose
    private TimeTrackingBean timetracking;
    @Expose
    private String updated;
    @Expose
    private List<VersionBean> versions;
    @Expose
    private VotesBean votes;
    @Expose
    private WatchesBean watches;
    @Expose
    private WorklogBean worklog;
    @Expose
    private Integer workratio;

    private List<CustomFieldBaseBean> customFields;

    public AggregateProgressBean getAggregateprogress() {
        return aggregateprogress;
    }

    public void setAggregateprogress(AggregateProgressBean aggregateprogress) {
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

    public UserBean getAssignee() {
        return assignee;
    }

    public void setAssignee(UserBean assignee) {
        this.assignee = assignee;
    }

    public List<AttachmentBean> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<AttachmentBean> attachment) {
        this.attachment = attachment;
    }

    public CommentsBean getComment() {
        return comment;
    }

    public void setComment(CommentsBean comment) {
        this.comment = comment;
    }

    public List<ComponentBean> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentBean> components) {
        this.components = components;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public UserBean getCreator() {
        return creator;
    }

    public void setCreator(UserBean creator) {
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

    public List<VersionBean> getFixVersions() {
        return fixVersions;
    }

    public void setFixVersions(List<VersionBean> fixVersions) {
        this.fixVersions = fixVersions;
    }

    public List<IssuelinkBean> getIssuelinks() {
        return issuelinks;
    }

    public void setIssuelinks(List<IssuelinkBean> issuelinks) {
        this.issuelinks = issuelinks;
    }

    public IssuetypeBean getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssuetypeBean issuetype) {
        this.issuetype = issuetype;
    }

    public IssueBean getParent() {
        return parent;
    }

    public void setParent(IssueBean parent) {
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

    public PriorityBean getPriority() {
        return priority;
    }

    public void setPriority(PriorityBean priority) {
        this.priority = priority;
    }

    public ProgressBean getProgress() {
        return progress;
    }

    public void setProgress(ProgressBean progress) {
        this.progress = progress;
    }

    public ProjectBean getProject() {
        return project;
    }

    public void setProject(ProjectBean project) {
        this.project = project;
    }

    public UserBean getReporter() {
        return reporter;
    }

    public void setReporter(UserBean reporter) {
        this.reporter = reporter;
    }

    public ResolutionBean getResolution() {
        return resolution;
    }

    public void setResolution(ResolutionBean resolution) {
        this.resolution = resolution;
    }

    public String getResolutiondate() {
        return resolutiondate;
    }

    public void setResolutiondate(String resolutiondate) {
        this.resolutiondate = resolutiondate;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<IssueBean> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<IssueBean> subtasks) {
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

    public TimeTrackingBean getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(TimeTrackingBean timetracking) {
        this.timetracking = timetracking;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public List<VersionBean> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionBean> versions) {
        this.versions = versions;
    }

    public VotesBean getVotes() {
        return votes;
    }

    public void setVotes(VotesBean votes) {
        this.votes = votes;
    }

    public WatchesBean getWatches() {
        return watches;
    }

    public void setWatches(WatchesBean watches) {
        this.watches = watches;
    }

    public WorklogBean getWorklog() {
        return worklog;
    }

    public void setWorklog(WorklogBean worklog) {
        this.worklog = worklog;
    }

    public Integer getWorkratio() {
        return workratio;
    }

    public void setWorkratio(Integer workratio) {
        this.workratio = workratio;
    }

    public List<CustomFieldBaseBean> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomFieldBaseBean> customFields) {
        this.customFields = customFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldsBean)) return false;
        FieldsBean that = (FieldsBean) o;
        return Objects.equals(aggregateprogress, that.aggregateprogress) &&
                Objects.equals(aggregatetimeestimate, that.aggregatetimeestimate) &&
                Objects.equals(aggregatetimeoriginalestimate, that.aggregatetimeoriginalestimate) &&
                Objects.equals(aggregatetimespent, that.aggregatetimespent) &&
                Objects.equals(assignee, that.assignee) &&
                Objects.equals(attachment, that.attachment) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(components, that.components) &&
                Objects.equals(created, that.created) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(description, that.description) &&
                Objects.equals(duedate, that.duedate) &&
                Objects.equals(environment, that.environment) &&
                Objects.equals(fixVersions, that.fixVersions) &&
                Objects.equals(issuelinks, that.issuelinks) &&
                Objects.equals(issuetype, that.issuetype) &&
                Objects.equals(parent, that.parent) &&
                Objects.equals(labels, that.labels) &&
                Objects.equals(lastViewed, that.lastViewed) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(progress, that.progress) &&
                Objects.equals(project, that.project) &&
                Objects.equals(reporter, that.reporter) &&
                Objects.equals(resolution, that.resolution) &&
                Objects.equals(resolutiondate, that.resolutiondate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(subtasks, that.subtasks) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(timeestimate, that.timeestimate) &&
                Objects.equals(timeoriginalestimate, that.timeoriginalestimate) &&
                Objects.equals(timespent, that.timespent) &&
                Objects.equals(timetracking, that.timetracking) &&
                Objects.equals(updated, that.updated) &&
                Objects.equals(versions, that.versions) &&
                Objects.equals(votes, that.votes) &&
                Objects.equals(watches, that.watches) &&
                Objects.equals(worklog, that.worklog) &&
                Objects.equals(workratio, that.workratio) &&
                Objects.equals(customFields, that.customFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aggregateprogress, aggregatetimeestimate, aggregatetimeoriginalestimate, aggregatetimespent, assignee, attachment, comment, components, created, creator, description, duedate, environment, fixVersions, issuelinks, issuetype, parent, labels, lastViewed, priority, progress, project, reporter, resolution, resolutiondate, status, subtasks, summary, timeestimate, timeoriginalestimate, timespent, timetracking, updated, versions, votes, watches, worklog, workratio, customFields);
    }
}