package com.github.cschulc.jirarestservice.domain.notification;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.github.cschulc.jirarestservice.domain.field.FieldBean;
import com.github.cschulc.jirarestservice.domain.groups.GroupBean;
import com.github.cschulc.jirarestservice.domain.project.ProjectRoleBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

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
}
