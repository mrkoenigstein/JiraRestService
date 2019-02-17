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

import com.github.cschulc.jirarestservice.domain.avatar.AvatarUrlsBean;
import com.github.cschulc.jirarestservice.domain.system.AssigneeTypeEnum;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectBean)) return false;
        if (!super.equals(o)) return false;
        ProjectBean that = (ProjectBean) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(lead, that.lead) &&
                Objects.equals(avatarUrls, that.avatarUrls) &&
                Objects.equals(key, that.key) &&
                Objects.equals(projectTypeKey, that.projectTypeKey) &&
                Objects.equals(components, that.components) &&
                Objects.equals(versions, that.versions) &&
                Objects.equals(issueTypes, that.issueTypes) &&
                assigneeType == that.assigneeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, lead, avatarUrls, key, projectTypeKey, components, versions, issueTypes, assigneeType);
    }
}
