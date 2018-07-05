package com.github.cschulc.jirarestservice.domain.project;

import com.github.cschulc.jirarestservice.domain.BaseJson;
import com.google.gson.annotations.Expose;

/**
 * For additional info see https://developer.atlassian.com/cloud/jira/platform/rest/#api-api-2-project-post
 *
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 04.07.2018
 * Time: 09:36
 */
public class CreateProject extends BaseJson {

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
}
