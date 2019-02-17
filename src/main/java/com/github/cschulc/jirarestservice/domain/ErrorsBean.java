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

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Objects;


public class ErrorsBean implements Serializable {

    private static final long serialVersionUID = 3263704272282751096L;

    @Expose
    private String project;
    @Expose
    private String subtasks;
    @Expose
    private String attachment;
    @Expose
    private String issuelinks;
    @Expose
    private String issuetype;
    @Expose
    private String reporter;
    @Expose
    private String assignee;
    @Expose
    private String environment;
    @Expose
    private String filterName;
    @Expose
    private String versions;
    @Expose
    private String components;
    @Expose
    private String email;
    @Expose
    private String projectType;
    @Expose
    private String projectKey;
    @Expose
    private String projectName;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(String subtasks) {
        this.subtasks = subtasks;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getIssuelinks() {
        return issuelinks;
    }

    public void setIssuelinks(String issuelinks) {
        this.issuelinks = issuelinks;
    }

    public String getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(String issuetype) {
        this.issuetype = issuetype;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorsBean)) return false;
        ErrorsBean that = (ErrorsBean) o;
        return Objects.equals(project, that.project) &&
                Objects.equals(subtasks, that.subtasks) &&
                Objects.equals(attachment, that.attachment) &&
                Objects.equals(issuelinks, that.issuelinks) &&
                Objects.equals(issuetype, that.issuetype) &&
                Objects.equals(reporter, that.reporter) &&
                Objects.equals(assignee, that.assignee) &&
                Objects.equals(environment, that.environment) &&
                Objects.equals(filterName, that.filterName) &&
                Objects.equals(versions, that.versions) &&
                Objects.equals(components, that.components) &&
                Objects.equals(email, that.email) &&
                Objects.equals(projectType, that.projectType) &&
                Objects.equals(projectKey, that.projectKey) &&
                Objects.equals(projectName, that.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, subtasks, attachment, issuelinks, issuetype, reporter, assignee, environment, filterName, versions, components, email, projectType, projectKey, projectName);
    }
}
