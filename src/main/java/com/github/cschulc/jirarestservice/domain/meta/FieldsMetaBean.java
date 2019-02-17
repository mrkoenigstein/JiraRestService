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

package com.github.cschulc.jirarestservice.domain.meta;

import com.github.cschulc.jirarestservice.domain.meta.fields.*;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FieldsMetaBean {

    @Expose
    private IssueTypeFieldMetaBean issuetype;

    @Expose
    private ComponentFieldMetaBean components;

    @Expose
    private FieldMetaBean description;

    @Expose
    private ProjectFieldMetaBean project;

    @Expose
    private VersionsFieldMetaBean fixVersions;

    @Expose
    private FieldMetaBean timetracking;

    @Expose
    private FieldMetaBean attachment;

    @Expose
    private FieldMetaBean summary;

    @Expose
    private FieldMetaBean reporter;

    @Expose
    private PriorityFieldMetaBean priority;

    @Expose
    private FieldMetaBean labels;

    @Expose
    private FieldMetaBean environment;

    @Expose
    private VersionsFieldMetaBean versions;

    @Expose
    private FieldMetaBean duedate;

    @Expose
    private FieldMetaBean assignee;

    private List<FieldMetaBean> custom = new ArrayList<>();

    public IssueTypeFieldMetaBean getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssueTypeFieldMetaBean issuetype) {
        this.issuetype = issuetype;
    }

    public ComponentFieldMetaBean getComponents() {
        return components;
    }

    public void setComponents(ComponentFieldMetaBean components) {
        this.components = components;
    }

    public FieldMetaBean getDescription() {
        return description;
    }

    public void setDescription(FieldMetaBean description) {
        this.description = description;
    }

    public ProjectFieldMetaBean getProject() {
        return project;
    }

    public void setProject(ProjectFieldMetaBean project) {
        this.project = project;
    }

    public VersionsFieldMetaBean getFixVersions() {
        return fixVersions;
    }

    public void setFixVersions(VersionsFieldMetaBean fixVersions) {
        this.fixVersions = fixVersions;
    }

    public FieldMetaBean getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(FieldMetaBean timetracking) {
        this.timetracking = timetracking;
    }

    public FieldMetaBean getAttachment() {
        return attachment;
    }

    public void setAttachment(FieldMetaBean attachment) {
        this.attachment = attachment;
    }

    public FieldMetaBean getSummary() {
        return summary;
    }

    public void setSummary(FieldMetaBean summary) {
        this.summary = summary;
    }

    public FieldMetaBean getReporter() {
        return reporter;
    }

    public void setReporter(FieldMetaBean reporter) {
        this.reporter = reporter;
    }

    public PriorityFieldMetaBean getPriority() {
        return priority;
    }

    public void setPriority(PriorityFieldMetaBean priority) {
        this.priority = priority;
    }

    public FieldMetaBean getLabels() {
        return labels;
    }

    public void setLabels(FieldMetaBean labels) {
        this.labels = labels;
    }

    public FieldMetaBean getEnvironment() {
        return environment;
    }

    public void setEnvironment(FieldMetaBean environment) {
        this.environment = environment;
    }

    public VersionsFieldMetaBean getVersions() {
        return versions;
    }

    public void setVersions(VersionsFieldMetaBean versions) {
        this.versions = versions;
    }

    public FieldMetaBean getDuedate() {
        return duedate;
    }

    public void setDuedate(FieldMetaBean duedate) {
        this.duedate = duedate;
    }

    public FieldMetaBean getAssignee() {
        return assignee;
    }

    public void setAssignee(FieldMetaBean assignee) {
        this.assignee = assignee;
    }

    public List<FieldMetaBean> getCustom() {
        return custom;
    }

    public void setCustom(List<FieldMetaBean> custom) {
        this.custom = custom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldsMetaBean)) return false;
        FieldsMetaBean that = (FieldsMetaBean) o;
        return Objects.equals(issuetype, that.issuetype) &&
                Objects.equals(components, that.components) &&
                Objects.equals(description, that.description) &&
                Objects.equals(project, that.project) &&
                Objects.equals(fixVersions, that.fixVersions) &&
                Objects.equals(timetracking, that.timetracking) &&
                Objects.equals(attachment, that.attachment) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(reporter, that.reporter) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(labels, that.labels) &&
                Objects.equals(environment, that.environment) &&
                Objects.equals(versions, that.versions) &&
                Objects.equals(duedate, that.duedate) &&
                Objects.equals(assignee, that.assignee) &&
                Objects.equals(custom, that.custom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuetype, components, description, project, fixVersions, timetracking, attachment, summary, reporter, priority, labels, environment, versions, duedate, assignee, custom);
    }
}
