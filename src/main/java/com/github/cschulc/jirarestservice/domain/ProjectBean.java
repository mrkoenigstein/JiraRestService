package com.github.cschulc.jirarestservice.domain;

import com.github.cschulc.jirarestservice.domain.avatar.AvatarUrlsBean;
import com.github.cschulc.jirarestservice.domain.system.AssigneeTypeEnum;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;

import java.util.List;

public class ProjectBean extends BaseBean {

    @Expose
    private String description;
    @Expose
    private UserBean lead;
    @Expose
    private AvatarUrlsBean avatarUrls;
    @Expose
    private String key;
    @Expose
    private String projectTypeKey;
    @Expose
    private List<ComponentBean> components;
    @Expose
    private List<VersionBean> versions;
    @Expose
    private List<IssuetypeBean> issueTypes;
    @Expose
    private AssigneeTypeEnum assigneeType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserBean getLead() {
        return lead;
    }

    public void setLead(UserBean lead) {
        this.lead = lead;
    }

    public AvatarUrlsBean getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(AvatarUrlsBean avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProjectTypeKey() {
        return projectTypeKey;
    }

    public void setProjectTypeKey(String projectTypeKey) {
        this.projectTypeKey = projectTypeKey;
    }

    public List<ComponentBean> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentBean> components) {
        this.components = components;
    }

    public List<VersionBean> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionBean> versions) {
        this.versions = versions;
    }

    public List<IssuetypeBean> getIssueTypes() {
        return issueTypes;
    }

    public void setIssueTypes(List<IssuetypeBean> issueTypes) {
        this.issueTypes = issueTypes;
    }

    public AssigneeTypeEnum getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(AssigneeTypeEnum assigneeType) {
        this.assigneeType = assigneeType;
    }
}
