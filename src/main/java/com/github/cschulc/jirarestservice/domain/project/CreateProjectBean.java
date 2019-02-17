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

package com.github.cschulc.jirarestservice.domain.project;

import com.github.cschulc.jirarestservice.domain.BaseJsonBean;
import com.google.gson.annotations.Expose;

import java.util.Objects;

/**
 * For additional info see https://developer.atlassian.com/cloud/jira/platform/rest/#api-api-2-project-post
 *
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 04.07.2018
 * Time: 09:36
 */
public class CreateProjectBean extends BaseJsonBean {

    @Expose
    private String assigneeType;

    @Expose
    private int avatarId;

    @Expose
    private int categoryId;

    @Expose
    private String description;

    @Expose
    private int issueSecurityScheme;

    @Expose
    private String key;

    @Expose
    private String lead;

    @Expose
    private String name;

    @Expose
    private int notificationScheme;

    @Expose
    private int permissionScheme;

    @Expose
    private String projectTemplateKey;

    @Expose
    private String projectTypeKey;

    @Expose
    private String url;

    public String getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(String assigneeType) {
        this.assigneeType = assigneeType;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIssueSecurityScheme() {
        return issueSecurityScheme;
    }

    public void setIssueSecurityScheme(int issueSecurityScheme) {
        this.issueSecurityScheme = issueSecurityScheme;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNotificationScheme() {
        return notificationScheme;
    }

    public void setNotificationScheme(int notificationScheme) {
        this.notificationScheme = notificationScheme;
    }

    public int getPermissionScheme() {
        return permissionScheme;
    }

    public void setPermissionScheme(int permissionScheme) {
        this.permissionScheme = permissionScheme;
    }

    public String getProjectTemplateKey() {
        return projectTemplateKey;
    }

    public void setProjectTemplateKey(String projectTemplateKey) {
        this.projectTemplateKey = projectTemplateKey;
    }

    public String getProjectTypeKey() {
        return projectTypeKey;
    }

    public void setProjectTypeKey(String projectTypeKey) {
        this.projectTypeKey = projectTypeKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateProjectBean)) return false;
        CreateProjectBean that = (CreateProjectBean) o;
        return avatarId == that.avatarId &&
                categoryId == that.categoryId &&
                issueSecurityScheme == that.issueSecurityScheme &&
                notificationScheme == that.notificationScheme &&
                permissionScheme == that.permissionScheme &&
                Objects.equals(assigneeType, that.assigneeType) &&
                Objects.equals(description, that.description) &&
                Objects.equals(key, that.key) &&
                Objects.equals(lead, that.lead) &&
                Objects.equals(name, that.name) &&
                Objects.equals(projectTemplateKey, that.projectTemplateKey) &&
                Objects.equals(projectTypeKey, that.projectTypeKey) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assigneeType, avatarId, categoryId, description, issueSecurityScheme, key, lead, name, notificationScheme, permissionScheme, projectTemplateKey, projectTypeKey, url);
    }
}
