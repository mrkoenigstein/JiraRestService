package com.github.cschulc.jirarestservice.domain;

import com.github.cschulc.jirarestservice.domain.system.AssigneeTypeEnum;
import com.google.gson.annotations.Expose;

import java.util.List;

public class Project extends Base {

    @Expose
    private AvatarUrls avatarUrls;
    @Expose
    private String key;
    @Expose
    private List<Component> components;
    @Expose
    private List<Version> versions;
    @Expose
    private List<Issuetype> issueTypes;
    @Expose
    private AssigneeTypeEnum assigneeType;

    public AvatarUrls getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(AvatarUrls avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    public List<Issuetype> getIssueTypes() {
        return issueTypes;
    }

    public void setIssueTypes(List<Issuetype> issueTypes) {
        this.issueTypes = issueTypes;
    }

    public AssigneeTypeEnum getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(AssigneeTypeEnum assigneeType) {
        this.assigneeType = assigneeType;
    }
}
