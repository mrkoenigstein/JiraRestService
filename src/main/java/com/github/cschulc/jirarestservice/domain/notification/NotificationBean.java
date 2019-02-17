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

package com.github.cschulc.jirarestservice.domain.notification;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.github.cschulc.jirarestservice.domain.field.FieldBean;
import com.github.cschulc.jirarestservice.domain.groups.GroupBean;
import com.github.cschulc.jirarestservice.domain.project.ProjectRoleBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author Christian Schulze
 */
public class NotificationBean extends BaseBean {

    @Expose
    private String notificationType = StringUtils.EMPTY;

    @Expose
    private String parameter = StringUtils.EMPTY;

    @Expose
    private ProjectRoleBean projectRole;

    @Expose
    private UserBean user;

    @Expose
    private FieldBean field;

    @Expose
    private GroupBean group;

    @Expose
    private String emailAddress = StringUtils.EMPTY;

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public ProjectRoleBean getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(ProjectRoleBean projectRole) {
        this.projectRole = projectRole;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public FieldBean getField() {
        return field;
    }

    public void setField(FieldBean field) {
        this.field = field;
    }

    public GroupBean getGroup() {
        return group;
    }

    public void setGroup(GroupBean group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationBean)) return false;
        if (!super.equals(o)) return false;
        NotificationBean that = (NotificationBean) o;
        return Objects.equals(notificationType, that.notificationType) &&
                Objects.equals(parameter, that.parameter) &&
                Objects.equals(projectRole, that.projectRole) &&
                Objects.equals(user, that.user) &&
                Objects.equals(field, that.field) &&
                Objects.equals(group, that.group) &&
                Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), notificationType, parameter, projectRole, user, field, group, emailAddress);
    }
}
