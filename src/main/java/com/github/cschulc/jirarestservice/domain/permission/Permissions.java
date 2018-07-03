package com.github.cschulc.jirarestservice.domain.permission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Permissions {

    @SerializedName("VIEW_WORKFLOW_READONLY")
    @Expose
    private UserPermission viewWorkflowReadonly;

    @SerializedName("CREATE_ISSUES")
    @Expose
    private UserPermission createIssues;

    @SerializedName("BULK_CHANGE")
    @Expose
    private UserPermission bulkChange;

    @SerializedName("CREATE_ATTACHMENT")
    @Expose
    private UserPermission createAttachment;

    @SerializedName("DELETE_OWN_COMMENTS")
    @Expose
    private UserPermission deleteOwnComments;

    @SerializedName("WORK_ON_ISSUES")
    @Expose
    private UserPermission workOnIssues;

    @SerializedName("PROJECT_ADMIN")
    @Expose
    private UserPermission projectAdmin;

    @SerializedName("COMMENT_EDIT_ALL")
    @Expose
    private UserPermission commentEditAll;

    @SerializedName("ATTACHMENT_DELETE_OWN")
    @Expose
    private UserPermission attachmentDeleteOwn;

    @SerializedName("WORKLOG_DELETE_OWN")
    @Expose
    private UserPermission worklogDeleteOwn;

    @SerializedName("CLOSE_ISSUE")
    @Expose
    private UserPermission closeIssue;

    @SerializedName("MANAGE_WATCHER_LIST")
    @Expose
    private UserPermission manageWatcherList;

    @SerializedName("VIEW_VOTERS_AND_WATCHERS")
    @Expose
    private UserPermission viewVotersAndWatchers;

    @SerializedName("ADD_COMMENTS")
    @Expose
    private UserPermission addComments;

    @SerializedName("COMMENT_DELETE_ALL")
    @Expose
    private UserPermission commentDeleteAll;

    @SerializedName("CREATE_ISSUE")
    @Expose
    private UserPermission createIssue;

    @SerializedName("DELETE_OWN_ATTACHMENTS")
    @Expose
    private UserPermission deleteOwnAttachments;

    @SerializedName("ASSIGN_ISSUE")
    @Expose
    private UserPermission assignIssue;

    @SerializedName("LINK_ISSUE")
    @Expose
    private UserPermission linkIssue;

    @SerializedName("EDIT_OWN_WORKLOGS")
    @Expose
    private UserPermission editOwnWorklogs;

    @SerializedName("CREATE_ATTACHMENTS")
    @Expose
    private UserPermission createAttachments;

    @SerializedName("EDIT_ALL_WORKLOGS")
    @Expose
    private UserPermission editAllWorklogs;

    @SerializedName("SCHEDULE_ISSUE")
    @Expose
    private UserPermission scheduleIssue;

    @SerializedName("CLOSE_ISSUES")
    @Expose
    private UserPermission closeIssues;

    @SerializedName("SET_ISSUE_SECURITY")
    @Expose
    private UserPermission setIssueSecurity;

    @SerializedName("SCHEDULE_ISSUES")
    @Expose
    private UserPermission scheduleIssues;

    @SerializedName("WORKLOG_DELETE_ALL")
    @Expose
    private UserPermission worklogDeleteAll;

    @SerializedName("COMMENT_DELETE_OWN")
    @Expose
    private UserPermission commentDeleteOwn;

    @SerializedName("ADMINISTER_PROJECTS")
    @Expose
    private UserPermission administerProjects;

    @SerializedName("DELETE_ALL_COMMENTS")
    @Expose
    private UserPermission deleteAllComments;

    @SerializedName("RESOLVE_ISSUES")
    @Expose
    private UserPermission resolveIssues;

    @SerializedName("VIEW_READONLY_WORKFLOW")
    @Expose
    private UserPermission viewReadonlyWorkflow;

    @SerializedName("ADMINISTER")
    @Expose
    private UserPermission administer;

    @SerializedName("MOVE_ISSUES")
    @Expose
    private UserPermission moveIssues;

    @SerializedName("TRANSITION_ISSUES")
    @Expose
    private UserPermission transitionIssues;

    @SerializedName("SYSTEM_ADMIN")
    @Expose
    private UserPermission systemAdmin;

    @SerializedName("DELETE_OWN_WORKLOGS")
    @Expose
    private UserPermission deleteOwnWorklogs;

    @SerializedName("BROWSE")
    @Expose
    private UserPermission brwose;

    @SerializedName("EDIT_ISSUE")
    @Expose
    private UserPermission editIssue;

    @SerializedName("MODIFY_REPORTER")
    @Expose
    private UserPermission modifyReporter;

    @SerializedName("EDIT_ISSUES")
    @Expose
    private UserPermission editIssues;

    @SerializedName("MANAGE_WATCHERS")
    @Expose
    private UserPermission manageWatchers;

    @SerializedName("EDIT_OWN_COMMENTS")
    @Expose
    private UserPermission editOwnComments;

    @SerializedName("ASSIGN_ISSUES")
    @Expose
    private UserPermission assignIssues;

    @SerializedName("BROWSE_PROJECTS")
    @Expose
    private UserPermission browseProjects;

    @SerializedName("VIEW_VERSION_CONTROL")
    @Expose
    private UserPermission viewVersionControl;

    @SerializedName("WORK_ISSUE")
    @Expose
    private UserPermission workIssue;

    @SerializedName("COMMENT_ISSUE")
    @Expose
    private UserPermission commentIssue;

    @SerializedName("WORKLOG_EDIT_ALL")
    @Expose
    private UserPermission worklogEditAll;

    @SerializedName("EDIT_ALL_COMMENTS")
    @Expose
    private UserPermission editAllComments;

    @SerializedName("DELETE_ISSUE")
    @Expose
    private UserPermission deleteIssue;

    @SerializedName("USER_PICKER")
    @Expose
    private UserPermission userPicker;

    @SerializedName("CREATE_SHARED_OBJECTS")
    @Expose
    private UserPermission createSharedObjects;

    @SerializedName("ATTACHMENT_DELETE_ALL")
    @Expose
    private UserPermission attachmentDeleteAll;

    @SerializedName("DELETE_ISSUES")
    @Expose
    private UserPermission deleteIssues;

    @SerializedName("MANAGE_GROUP_FILTER_SUBSCRIPTIONS")
    @Expose
    private UserPermission manageGroupFilterSubscriptions;

    @SerializedName("RESOLVE_ISSUE")
    @Expose
    private UserPermission resolveIssue;

    @SerializedName("ASSIGNABLE_USER")
    @Expose
    private UserPermission assignableUser;

    @SerializedName("TRANSITION_ISSUE")
    @Expose
    private UserPermission transitionIssue;

    @SerializedName("COMMENT_EDIT_OWN")
    @Expose
    private UserPermission commentEditOwn;

    @SerializedName("MOVE_ISSUE")
    @Expose
    private UserPermission moveIssue;

    @SerializedName("WORKLOG_EDIT_OWN")
    @Expose
    private UserPermission worklogEditOwn;

    @SerializedName("DELETE_ALL_WORKLOGS")
    @Expose
    private UserPermission deleteAllWorklogs;

    @SerializedName("LINK_ISSUES")
    @Expose
    private UserPermission linkIssues;

    public UserPermission getViewWorkflowReadonly() {
        return viewWorkflowReadonly;
    }

    public void setViewWorkflowReadonly(UserPermission viewWorkflowReadonly) {
        this.viewWorkflowReadonly = viewWorkflowReadonly;
    }

    public UserPermission getCreateIssues() {
        return createIssues;
    }

    public void setCreateIssues(UserPermission createIssues) {
        this.createIssues = createIssues;
    }

    public UserPermission getBulkChange() {
        return bulkChange;
    }

    public void setBulkChange(UserPermission bulkChange) {
        this.bulkChange = bulkChange;
    }

    public UserPermission getCreateAttachment() {
        return createAttachment;
    }

    public void setCreateAttachment(UserPermission createAttachment) {
        this.createAttachment = createAttachment;
    }

    public UserPermission getDeleteOwnComments() {
        return deleteOwnComments;
    }

    public void setDeleteOwnComments(UserPermission deleteOwnComments) {
        this.deleteOwnComments = deleteOwnComments;
    }

    public UserPermission getWorkOnIssues() {
        return workOnIssues;
    }

    public void setWorkOnIssues(UserPermission workOnIssues) {
        this.workOnIssues = workOnIssues;
    }

    public UserPermission getProjectAdmin() {
        return projectAdmin;
    }

    public void setProjectAdmin(UserPermission projectAdmin) {
        this.projectAdmin = projectAdmin;
    }

    public UserPermission getCommentEditAll() {
        return commentEditAll;
    }

    public void setCommentEditAll(UserPermission commentEditAll) {
        this.commentEditAll = commentEditAll;
    }

    public UserPermission getAttachmentDeleteOwn() {
        return attachmentDeleteOwn;
    }

    public void setAttachmentDeleteOwn(UserPermission attachmentDeleteOwn) {
        this.attachmentDeleteOwn = attachmentDeleteOwn;
    }

    public UserPermission getWorklogDeleteOwn() {
        return worklogDeleteOwn;
    }

    public void setWorklogDeleteOwn(UserPermission worklogDeleteOwn) {
        this.worklogDeleteOwn = worklogDeleteOwn;
    }

    public UserPermission getCloseIssue() {
        return closeIssue;
    }

    public void setCloseIssue(UserPermission closeIssue) {
        this.closeIssue = closeIssue;
    }

    public UserPermission getManageWatcherList() {
        return manageWatcherList;
    }

    public void setManageWatcherList(UserPermission manageWatcherList) {
        this.manageWatcherList = manageWatcherList;
    }

    public UserPermission getViewVotersAndWatchers() {
        return viewVotersAndWatchers;
    }

    public void setViewVotersAndWatchers(UserPermission viewVotersAndWatchers) {
        this.viewVotersAndWatchers = viewVotersAndWatchers;
    }

    public UserPermission getAddComments() {
        return addComments;
    }

    public void setAddComments(UserPermission addComments) {
        this.addComments = addComments;
    }

    public UserPermission getCommentDeleteAll() {
        return commentDeleteAll;
    }

    public void setCommentDeleteAll(UserPermission commentDeleteAll) {
        this.commentDeleteAll = commentDeleteAll;
    }

    public UserPermission getCreateIssue() {
        return createIssue;
    }

    public void setCreateIssue(UserPermission createIssue) {
        this.createIssue = createIssue;
    }

    public UserPermission getDeleteOwnAttachments() {
        return deleteOwnAttachments;
    }

    public void setDeleteOwnAttachments(UserPermission deleteOwnAttachments) {
        this.deleteOwnAttachments = deleteOwnAttachments;
    }

    public UserPermission getAssignIssue() {
        return assignIssue;
    }

    public void setAssignIssue(UserPermission assignIssue) {
        this.assignIssue = assignIssue;
    }

    public UserPermission getLinkIssue() {
        return linkIssue;
    }

    public void setLinkIssue(UserPermission linkIssue) {
        this.linkIssue = linkIssue;
    }

    public UserPermission getEditOwnWorklogs() {
        return editOwnWorklogs;
    }

    public void setEditOwnWorklogs(UserPermission editOwnWorklogs) {
        this.editOwnWorklogs = editOwnWorklogs;
    }

    public UserPermission getCreateAttachments() {
        return createAttachments;
    }

    public void setCreateAttachments(UserPermission createAttachments) {
        this.createAttachments = createAttachments;
    }

    public UserPermission getEditAllWorklogs() {
        return editAllWorklogs;
    }

    public void setEditAllWorklogs(UserPermission editAllWorklogs) {
        this.editAllWorklogs = editAllWorklogs;
    }

    public UserPermission getScheduleIssue() {
        return scheduleIssue;
    }

    public void setScheduleIssue(UserPermission scheduleIssue) {
        this.scheduleIssue = scheduleIssue;
    }

    public UserPermission getCloseIssues() {
        return closeIssues;
    }

    public void setCloseIssues(UserPermission closeIssues) {
        this.closeIssues = closeIssues;
    }

    public UserPermission getSetIssueSecurity() {
        return setIssueSecurity;
    }

    public void setSetIssueSecurity(UserPermission setIssueSecurity) {
        this.setIssueSecurity = setIssueSecurity;
    }

    public UserPermission getScheduleIssues() {
        return scheduleIssues;
    }

    public void setScheduleIssues(UserPermission scheduleIssues) {
        this.scheduleIssues = scheduleIssues;
    }

    public UserPermission getWorklogDeleteAll() {
        return worklogDeleteAll;
    }

    public void setWorklogDeleteAll(UserPermission worklogDeleteAll) {
        this.worklogDeleteAll = worklogDeleteAll;
    }

    public UserPermission getCommentDeleteOwn() {
        return commentDeleteOwn;
    }

    public void setCommentDeleteOwn(UserPermission commentDeleteOwn) {
        this.commentDeleteOwn = commentDeleteOwn;
    }

    public UserPermission getAdministerProjects() {
        return administerProjects;
    }

    public void setAdministerProjects(UserPermission administerProjects) {
        this.administerProjects = administerProjects;
    }

    public UserPermission getDeleteAllComments() {
        return deleteAllComments;
    }

    public void setDeleteAllComments(UserPermission deleteAllComments) {
        this.deleteAllComments = deleteAllComments;
    }

    public UserPermission getResolveIssues() {
        return resolveIssues;
    }

    public void setResolveIssues(UserPermission resolveIssues) {
        this.resolveIssues = resolveIssues;
    }

    public UserPermission getViewReadonlyWorkflow() {
        return viewReadonlyWorkflow;
    }

    public void setViewReadonlyWorkflow(UserPermission viewReadonlyWorkflow) {
        this.viewReadonlyWorkflow = viewReadonlyWorkflow;
    }

    public UserPermission getAdminister() {
        return administer;
    }

    public void setAdminister(UserPermission administer) {
        this.administer = administer;
    }

    public UserPermission getMoveIssues() {
        return moveIssues;
    }

    public void setMoveIssues(UserPermission moveIssues) {
        this.moveIssues = moveIssues;
    }

    public UserPermission getTransitionIssues() {
        return transitionIssues;
    }

    public void setTransitionIssues(UserPermission transitionIssues) {
        this.transitionIssues = transitionIssues;
    }

    public UserPermission getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(UserPermission systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public UserPermission getDeleteOwnWorklogs() {
        return deleteOwnWorklogs;
    }

    public void setDeleteOwnWorklogs(UserPermission deleteOwnWorklogs) {
        this.deleteOwnWorklogs = deleteOwnWorklogs;
    }

    public UserPermission getBrwose() {
        return brwose;
    }

    public void setBrwose(UserPermission brwose) {
        this.brwose = brwose;
    }

    public UserPermission getEditIssue() {
        return editIssue;
    }

    public void setEditIssue(UserPermission editIssue) {
        this.editIssue = editIssue;
    }

    public UserPermission getModifyReporter() {
        return modifyReporter;
    }

    public void setModifyReporter(UserPermission modifyReporter) {
        this.modifyReporter = modifyReporter;
    }

    public UserPermission getEditIssues() {
        return editIssues;
    }

    public void setEditIssues(UserPermission editIssues) {
        this.editIssues = editIssues;
    }

    public UserPermission getManageWatchers() {
        return manageWatchers;
    }

    public void setManageWatchers(UserPermission manageWatchers) {
        this.manageWatchers = manageWatchers;
    }

    public UserPermission getEditOwnComments() {
        return editOwnComments;
    }

    public void setEditOwnComments(UserPermission editOwnComments) {
        this.editOwnComments = editOwnComments;
    }

    public UserPermission getAssignIssues() {
        return assignIssues;
    }

    public void setAssignIssues(UserPermission assignIssues) {
        this.assignIssues = assignIssues;
    }

    public UserPermission getBrowseProjects() {
        return browseProjects;
    }

    public void setBrowseProjects(UserPermission browseProjects) {
        this.browseProjects = browseProjects;
    }

    public UserPermission getViewVersionControl() {
        return viewVersionControl;
    }

    public void setViewVersionControl(UserPermission viewVersionControl) {
        this.viewVersionControl = viewVersionControl;
    }

    public UserPermission getWorkIssue() {
        return workIssue;
    }

    public void setWorkIssue(UserPermission workIssue) {
        this.workIssue = workIssue;
    }

    public UserPermission getCommentIssue() {
        return commentIssue;
    }

    public void setCommentIssue(UserPermission commentIssue) {
        this.commentIssue = commentIssue;
    }

    public UserPermission getWorklogEditAll() {
        return worklogEditAll;
    }

    public void setWorklogEditAll(UserPermission worklogEditAll) {
        this.worklogEditAll = worklogEditAll;
    }

    public UserPermission getEditAllComments() {
        return editAllComments;
    }

    public void setEditAllComments(UserPermission editAllComments) {
        this.editAllComments = editAllComments;
    }

    public UserPermission getDeleteIssue() {
        return deleteIssue;
    }

    public void setDeleteIssue(UserPermission deleteIssue) {
        this.deleteIssue = deleteIssue;
    }

    public UserPermission getUserPicker() {
        return userPicker;
    }

    public void setUserPicker(UserPermission userPicker) {
        this.userPicker = userPicker;
    }

    public UserPermission getCreateSharedObjects() {
        return createSharedObjects;
    }

    public void setCreateSharedObjects(UserPermission createSharedObjects) {
        this.createSharedObjects = createSharedObjects;
    }

    public UserPermission getAttachmentDeleteAll() {
        return attachmentDeleteAll;
    }

    public void setAttachmentDeleteAll(UserPermission attachmentDeleteAll) {
        this.attachmentDeleteAll = attachmentDeleteAll;
    }

    public UserPermission getDeleteIssues() {
        return deleteIssues;
    }

    public void setDeleteIssues(UserPermission deleteIssues) {
        this.deleteIssues = deleteIssues;
    }

    public UserPermission getManageGroupFilterSubscriptions() {
        return manageGroupFilterSubscriptions;
    }

    public void setManageGroupFilterSubscriptions(UserPermission manageGroupFilterSubscriptions) {
        this.manageGroupFilterSubscriptions = manageGroupFilterSubscriptions;
    }

    public UserPermission getResolveIssue() {
        return resolveIssue;
    }

    public void setResolveIssue(UserPermission resolveIssue) {
        this.resolveIssue = resolveIssue;
    }

    public UserPermission getAssignableUser() {
        return assignableUser;
    }

    public void setAssignableUser(UserPermission assignableUser) {
        this.assignableUser = assignableUser;
    }

    public UserPermission getTransitionIssue() {
        return transitionIssue;
    }

    public void setTransitionIssue(UserPermission transitionIssue) {
        this.transitionIssue = transitionIssue;
    }

    public UserPermission getCommentEditOwn() {
        return commentEditOwn;
    }

    public void setCommentEditOwn(UserPermission commentEditOwn) {
        this.commentEditOwn = commentEditOwn;
    }

    public UserPermission getMoveIssue() {
        return moveIssue;
    }

    public void setMoveIssue(UserPermission moveIssue) {
        this.moveIssue = moveIssue;
    }

    public UserPermission getWorklogEditOwn() {
        return worklogEditOwn;
    }

    public void setWorklogEditOwn(UserPermission worklogEditOwn) {
        this.worklogEditOwn = worklogEditOwn;
    }

    public UserPermission getDeleteAllWorklogs() {
        return deleteAllWorklogs;
    }

    public void setDeleteAllWorklogs(UserPermission deleteAllWorklogs) {
        this.deleteAllWorklogs = deleteAllWorklogs;
    }

    public UserPermission getLinkIssues() {
        return linkIssues;
    }

    public void setLinkIssues(UserPermission linkIssues) {
        this.linkIssues = linkIssues;
    }
}
