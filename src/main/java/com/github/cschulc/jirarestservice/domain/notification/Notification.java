package com.github.cschulc.jirarestservice.domain.notification;

import com.github.cschulc.jirarestservice.domain.Base;
import com.github.cschulc.jirarestservice.domain.Group;
import com.github.cschulc.jirarestservice.domain.User;
import com.github.cschulc.jirarestservice.domain.field.Field;
import com.github.cschulc.jirarestservice.domain.project.ProjectRole;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Christian Schulze
 */
public class Notification extends Base {

    @Expose
    private String notificationType = StringUtils.EMPTY;

    @Expose
    private String parameter = StringUtils.EMPTY;

    @Expose
    private ProjectRole projectRole;

    @Expose
    private User user;

    @Expose
    private Field field;

    @Expose
    private Group group;

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

    public ProjectRole getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(ProjectRole projectRole) {
        this.projectRole = projectRole;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
