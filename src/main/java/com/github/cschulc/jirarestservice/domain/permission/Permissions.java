package com.github.cschulc.jirarestservice.domain.permission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Permissions {

    @SerializedName("VIEW_WORKFLOW_READONLY")
    @Expose
    private Permission viewWorkflowReadonly;

    @SerializedName("CREATE_ISSUES")
    @Expose
    private Permission createIssues;

    @SerializedName("BULK_CHANGE")
    @Expose
    private Permission bulkChange;

    @SerializedName("CREATE_ATTACHMENT")
    @Expose
    private Permission createAttachment;

    @SerializedName("DELETE_OWN_COMMENTS")
    @Expose
    private Permission deleteOwnComments;

    @SerializedName("WORK_ON_ISSUES")
    @Expose
    private Permission workOnIssues;

    @SerializedName("PROJECT_ADMIN")
    @Expose
    private Permission projectAdmin;

    @SerializedName("COMMENT_EDIT_ALL")
    @Expose
    private Permission commentEditAll;

    @SerializedName("ATTACHMENT_DELETE_OWN")
    @Expose
    private Permission attachmentDeleteOwn;

    @SerializedName("WORKLOG_DELETE_OWN")
    @Expose
    private Permission worklogDeleteOwn;

    @SerializedName("CLOSE_ISSUE")
    @Expose
    private Permission closeIssue;

    @SerializedName("MANAGE_WATCHER_LIST")
    @Expose
    private Permission manageWatcherList;

    @SerializedName("VIEW_VOTERS_AND_WATCHERS")
    @Expose
    private Permission viewVotersAndWatchers;

    @SerializedName("ADD_COMMENTS")
    @Expose
    private Permission addComments;

    @SerializedName("COMMENT_DELETE_ALL")
    @Expose
    private Permission commentDeleteAll;

    @SerializedName("CREATE_ISSUE")
    @Expose
    private Permission createIssue;

    @SerializedName("DELETE_OWN_ATTACHMENTS")
    @Expose
    private Permission deleteOwnAttachments;

    @SerializedName("ASSIGN_ISSUE")
    @Expose
    private Permission assignIssue;

    @SerializedName("LINK_ISSUE")
    @Expose
    private Permission linkIssue;

    @SerializedName("EDIT_OWN_WORKLOGS")
    @Expose
    private Permission editOwnWorklogs;

    @SerializedName("CREATE_ATTACHMENTS")
    @Expose
    private Permission createAttachments;

    @SerializedName("EDIT_ALL_WORKLOGS")
    @Expose
    private Permission editAllWorklogs;

    @SerializedName("SCHEDULE_ISSUE")
    @Expose
    private Permission scheduleIssue;

    @SerializedName("CLOSE_ISSUES")
    @Expose
    private Permission closeIssues;

    @SerializedName("SET_ISSUE_SECURITY")
    @Expose
    private Permission setIssueSecurity;

    @SerializedName("SCHEDULE_ISSUES")
    @Expose
    private Permission scheduleIssues;

    @SerializedName("WORKLOG_DELETE_ALL")
    @Expose
    private Permission worklogDeleteAll;

    @SerializedName("COMMENT_DELETE_OWN")
    @Expose
    private Permission commentDeleteOwn;

    @SerializedName("ADMINISTER_PROJECTS")
    @Expose
    private Permission administerProjects;

    @SerializedName("DELETE_ALL_COMMENTS")
    @Expose
    private Permission deleteAllComments;

    @SerializedName("RESOLVE_ISSUES")
    @Expose
    private Permission resolveIssues;

    @SerializedName("VIEW_READONLY_WORKFLOW")
    @Expose
    private Permission viewReadonlyWorkflow;

    @SerializedName("ADMINISTER")
    @Expose
    private Permission administer;

    @SerializedName("MOVE_ISSUES")
    @Expose
    private Permission moveIssues;

    @SerializedName("TRANSITION_ISSUES")
    @Expose
    private Permission transitionIssues;

    @SerializedName("SYSTEM_ADMIN")
    @Expose
    private Permission systemAdmin;

    @SerializedName("DELETE_OWN_WORKLOGS")
    @Expose
    private Permission deleteOwnWorklogs;

    @SerializedName("BROWSE")
    @Expose
    private Permission brwose;

    @SerializedName("EDIT_ISSUE")
    @Expose
    private Permission editIssue;

    @SerializedName("MODIFY_REPORTER")
    @Expose
    private Permission modifyReporter;

    @SerializedName("EDIT_ISSUES")
    @Expose
    private Permission editIssues;

    @SerializedName("MANAGE_WATCHERS")
    @Expose
    private Permission manageWatchers;

    @SerializedName("EDIT_OWN_COMMENTS")
    @Expose
    private Permission editOwnComments;

    @SerializedName("ASSIGN_ISSUES")
    @Expose
    private Permission assignIssues;

    @SerializedName("BROWSE_PROJECTS")
    @Expose
    private Permission browseProjects;

    @SerializedName("VIEW_VERSION_CONTROL")
    @Expose
    private Permission viewVersionControl;

    @SerializedName("WORK_ISSUE")
    @Expose
    private Permission workIssue;

    @SerializedName("COMMENT_ISSUE")
    @Expose
    private Permission commentIssue;

    @SerializedName("WORKLOG_EDIT_ALL")
    @Expose
    private Permission worklogEditAll;

    @SerializedName("EDIT_ALL_COMMENTS")
    @Expose
    private Permission editAllComments;

    @SerializedName("DELETE_ISSUE")
    @Expose
    private Permission deleteIssue;

    @SerializedName("USER_PICKER")
    @Expose
    private Permission userPicker;

    @SerializedName("CREATE_SHARED_OBJECTS")
    @Expose
    private Permission createSharedObjects;

    @SerializedName("ATTACHMENT_DELETE_ALL")
    @Expose
    private Permission attachmentDeleteAll;

    @SerializedName("DELETE_ISSUES")
    @Expose
    private Permission deleteIssues;

    @SerializedName("MANAGE_GROUP_FILTER_SUBSCRIPTIONS")
    @Expose
    private Permission manageGroupFilterSubscriptions;

    @SerializedName("RESOLVE_ISSUE")
    @Expose
    private Permission resolveIssue;

    @SerializedName("ASSIGNABLE_USER")
    @Expose
    private Permission assignableUser;

    @SerializedName("TRANSITION_ISSUE")
    @Expose
    private Permission transitionIssue;

    @SerializedName("COMMENT_EDIT_OWN")
    @Expose
    private Permission commentEditOwn;

    @SerializedName("MOVE_ISSUE")
    @Expose
    private Permission moveIssue;

    @SerializedName("WORKLOG_EDIT_OWN")
    @Expose
    private Permission worklogEditOwn;

    @SerializedName("DELETE_ALL_WORKLOGS")
    @Expose
    private Permission deleteAllWorklogs;

    @SerializedName("LINK_ISSUES")
    @Expose
    private Permission linkIssues;

    public Permission getViewWorkflowReadonly() {
        return viewWorkflowReadonly;
    }

    public void setViewWorkflowReadonly(Permission viewWorkflowReadonly) {
        this.viewWorkflowReadonly = viewWorkflowReadonly;
    }

    public Permission getCreateIssues() {
        return createIssues;
    }

    public void setCreateIssues(Permission createIssues) {
        this.createIssues = createIssues;
    }

    public Permission getBulkChange() {
        return bulkChange;
    }

    public void setBulkChange(Permission bulkChange) {
        this.bulkChange = bulkChange;
    }

    public Permission getCreateAttachment() {
        return createAttachment;
    }

    public void setCreateAttachment(Permission createAttachment) {
        this.createAttachment = createAttachment;
    }

    public Permission getDeleteOwnComments() {
        return deleteOwnComments;
    }

    public void setDeleteOwnComments(Permission deleteOwnComments) {
        this.deleteOwnComments = deleteOwnComments;
    }

    public Permission getWorkOnIssues() {
        return workOnIssues;
    }

    public void setWorkOnIssues(Permission workOnIssues) {
        this.workOnIssues = workOnIssues;
    }

    public Permission getProjectAdmin() {
        return projectAdmin;
    }

    public void setProjectAdmin(Permission projectAdmin) {
        this.projectAdmin = projectAdmin;
    }

    public Permission getCommentEditAll() {
        return commentEditAll;
    }

    public void setCommentEditAll(Permission commentEditAll) {
        this.commentEditAll = commentEditAll;
    }

    public Permission getAttachmentDeleteOwn() {
        return attachmentDeleteOwn;
    }

    public void setAttachmentDeleteOwn(Permission attachmentDeleteOwn) {
        this.attachmentDeleteOwn = attachmentDeleteOwn;
    }

    public Permission getWorklogDeleteOwn() {
        return worklogDeleteOwn;
    }

    public void setWorklogDeleteOwn(Permission worklogDeleteOwn) {
        this.worklogDeleteOwn = worklogDeleteOwn;
    }

    public Permission getCloseIssue() {
        return closeIssue;
    }

    public void setCloseIssue(Permission closeIssue) {
        this.closeIssue = closeIssue;
    }

    public Permission getManageWatcherList() {
        return manageWatcherList;
    }

    public void setManageWatcherList(Permission manageWatcherList) {
        this.manageWatcherList = manageWatcherList;
    }

    public Permission getViewVotersAndWatchers() {
        return viewVotersAndWatchers;
    }

    public void setViewVotersAndWatchers(Permission viewVotersAndWatchers) {
        this.viewVotersAndWatchers = viewVotersAndWatchers;
    }

    public Permission getAddComments() {
        return addComments;
    }

    public void setAddComments(Permission addComments) {
        this.addComments = addComments;
    }

    public Permission getCommentDeleteAll() {
        return commentDeleteAll;
    }

    public void setCommentDeleteAll(Permission commentDeleteAll) {
        this.commentDeleteAll = commentDeleteAll;
    }

    public Permission getCreateIssue() {
        return createIssue;
    }

    public void setCreateIssue(Permission createIssue) {
        this.createIssue = createIssue;
    }

    public Permission getDeleteOwnAttachments() {
        return deleteOwnAttachments;
    }

    public void setDeleteOwnAttachments(Permission deleteOwnAttachments) {
        this.deleteOwnAttachments = deleteOwnAttachments;
    }

    public Permission getAssignIssue() {
        return assignIssue;
    }

    public void setAssignIssue(Permission assignIssue) {
        this.assignIssue = assignIssue;
    }

    public Permission getLinkIssue() {
        return linkIssue;
    }

    public void setLinkIssue(Permission linkIssue) {
        this.linkIssue = linkIssue;
    }

    public Permission getEditOwnWorklogs() {
        return editOwnWorklogs;
    }

    public void setEditOwnWorklogs(Permission editOwnWorklogs) {
        this.editOwnWorklogs = editOwnWorklogs;
    }

    public Permission getCreateAttachments() {
        return createAttachments;
    }

    public void setCreateAttachments(Permission createAttachments) {
        this.createAttachments = createAttachments;
    }

    public Permission getEditAllWorklogs() {
        return editAllWorklogs;
    }

    public void setEditAllWorklogs(Permission editAllWorklogs) {
        this.editAllWorklogs = editAllWorklogs;
    }

    public Permission getScheduleIssue() {
        return scheduleIssue;
    }

    public void setScheduleIssue(Permission scheduleIssue) {
        this.scheduleIssue = scheduleIssue;
    }

    public Permission getCloseIssues() {
        return closeIssues;
    }

    public void setCloseIssues(Permission closeIssues) {
        this.closeIssues = closeIssues;
    }

    public Permission getSetIssueSecurity() {
        return setIssueSecurity;
    }

    public void setSetIssueSecurity(Permission setIssueSecurity) {
        this.setIssueSecurity = setIssueSecurity;
    }

    public Permission getScheduleIssues() {
        return scheduleIssues;
    }

    public void setScheduleIssues(Permission scheduleIssues) {
        this.scheduleIssues = scheduleIssues;
    }

    public Permission getWorklogDeleteAll() {
        return worklogDeleteAll;
    }

    public void setWorklogDeleteAll(Permission worklogDeleteAll) {
        this.worklogDeleteAll = worklogDeleteAll;
    }

    public Permission getCommentDeleteOwn() {
        return commentDeleteOwn;
    }

    public void setCommentDeleteOwn(Permission commentDeleteOwn) {
        this.commentDeleteOwn = commentDeleteOwn;
    }

    public Permission getAdministerProjects() {
        return administerProjects;
    }

    public void setAdministerProjects(Permission administerProjects) {
        this.administerProjects = administerProjects;
    }

    public Permission getDeleteAllComments() {
        return deleteAllComments;
    }

    public void setDeleteAllComments(Permission deleteAllComments) {
        this.deleteAllComments = deleteAllComments;
    }

    public Permission getResolveIssues() {
        return resolveIssues;
    }

    public void setResolveIssues(Permission resolveIssues) {
        this.resolveIssues = resolveIssues;
    }

    public Permission getViewReadonlyWorkflow() {
        return viewReadonlyWorkflow;
    }

    public void setViewReadonlyWorkflow(Permission viewReadonlyWorkflow) {
        this.viewReadonlyWorkflow = viewReadonlyWorkflow;
    }

    public Permission getAdminister() {
        return administer;
    }

    public void setAdminister(Permission administer) {
        this.administer = administer;
    }

    public Permission getMoveIssues() {
        return moveIssues;
    }

    public void setMoveIssues(Permission moveIssues) {
        this.moveIssues = moveIssues;
    }

    public Permission getTransitionIssues() {
        return transitionIssues;
    }

    public void setTransitionIssues(Permission transitionIssues) {
        this.transitionIssues = transitionIssues;
    }

    public Permission getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(Permission systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public Permission getDeleteOwnWorklogs() {
        return deleteOwnWorklogs;
    }

    public void setDeleteOwnWorklogs(Permission deleteOwnWorklogs) {
        this.deleteOwnWorklogs = deleteOwnWorklogs;
    }

    public Permission getBrwose() {
        return brwose;
    }

    public void setBrwose(Permission brwose) {
        this.brwose = brwose;
    }

    public Permission getEditIssue() {
        return editIssue;
    }

    public void setEditIssue(Permission editIssue) {
        this.editIssue = editIssue;
    }

    public Permission getModifyReporter() {
        return modifyReporter;
    }

    public void setModifyReporter(Permission modifyReporter) {
        this.modifyReporter = modifyReporter;
    }

    public Permission getEditIssues() {
        return editIssues;
    }

    public void setEditIssues(Permission editIssues) {
        this.editIssues = editIssues;
    }

    public Permission getManageWatchers() {
        return manageWatchers;
    }

    public void setManageWatchers(Permission manageWatchers) {
        this.manageWatchers = manageWatchers;
    }

    public Permission getEditOwnComments() {
        return editOwnComments;
    }

    public void setEditOwnComments(Permission editOwnComments) {
        this.editOwnComments = editOwnComments;
    }

    public Permission getAssignIssues() {
        return assignIssues;
    }

    public void setAssignIssues(Permission assignIssues) {
        this.assignIssues = assignIssues;
    }

    public Permission getBrowseProjects() {
        return browseProjects;
    }

    public void setBrowseProjects(Permission browseProjects) {
        this.browseProjects = browseProjects;
    }

    public Permission getViewVersionControl() {
        return viewVersionControl;
    }

    public void setViewVersionControl(Permission viewVersionControl) {
        this.viewVersionControl = viewVersionControl;
    }

    public Permission getWorkIssue() {
        return workIssue;
    }

    public void setWorkIssue(Permission workIssue) {
        this.workIssue = workIssue;
    }

    public Permission getCommentIssue() {
        return commentIssue;
    }

    public void setCommentIssue(Permission commentIssue) {
        this.commentIssue = commentIssue;
    }

    public Permission getWorklogEditAll() {
        return worklogEditAll;
    }

    public void setWorklogEditAll(Permission worklogEditAll) {
        this.worklogEditAll = worklogEditAll;
    }

    public Permission getEditAllComments() {
        return editAllComments;
    }

    public void setEditAllComments(Permission editAllComments) {
        this.editAllComments = editAllComments;
    }

    public Permission getDeleteIssue() {
        return deleteIssue;
    }

    public void setDeleteIssue(Permission deleteIssue) {
        this.deleteIssue = deleteIssue;
    }

    public Permission getUserPicker() {
        return userPicker;
    }

    public void setUserPicker(Permission userPicker) {
        this.userPicker = userPicker;
    }

    public Permission getCreateSharedObjects() {
        return createSharedObjects;
    }

    public void setCreateSharedObjects(Permission createSharedObjects) {
        this.createSharedObjects = createSharedObjects;
    }

    public Permission getAttachmentDeleteAll() {
        return attachmentDeleteAll;
    }

    public void setAttachmentDeleteAll(Permission attachmentDeleteAll) {
        this.attachmentDeleteAll = attachmentDeleteAll;
    }

    public Permission getDeleteIssues() {
        return deleteIssues;
    }

    public void setDeleteIssues(Permission deleteIssues) {
        this.deleteIssues = deleteIssues;
    }

    public Permission getManageGroupFilterSubscriptions() {
        return manageGroupFilterSubscriptions;
    }

    public void setManageGroupFilterSubscriptions(Permission manageGroupFilterSubscriptions) {
        this.manageGroupFilterSubscriptions = manageGroupFilterSubscriptions;
    }

    public Permission getResolveIssue() {
        return resolveIssue;
    }

    public void setResolveIssue(Permission resolveIssue) {
        this.resolveIssue = resolveIssue;
    }

    public Permission getAssignableUser() {
        return assignableUser;
    }

    public void setAssignableUser(Permission assignableUser) {
        this.assignableUser = assignableUser;
    }

    public Permission getTransitionIssue() {
        return transitionIssue;
    }

    public void setTransitionIssue(Permission transitionIssue) {
        this.transitionIssue = transitionIssue;
    }

    public Permission getCommentEditOwn() {
        return commentEditOwn;
    }

    public void setCommentEditOwn(Permission commentEditOwn) {
        this.commentEditOwn = commentEditOwn;
    }

    public Permission getMoveIssue() {
        return moveIssue;
    }

    public void setMoveIssue(Permission moveIssue) {
        this.moveIssue = moveIssue;
    }

    public Permission getWorklogEditOwn() {
        return worklogEditOwn;
    }

    public void setWorklogEditOwn(Permission worklogEditOwn) {
        this.worklogEditOwn = worklogEditOwn;
    }

    public Permission getDeleteAllWorklogs() {
        return deleteAllWorklogs;
    }

    public void setDeleteAllWorklogs(Permission deleteAllWorklogs) {
        this.deleteAllWorklogs = deleteAllWorklogs;
    }

    public Permission getLinkIssues() {
        return linkIssues;
    }

    public void setLinkIssues(Permission linkIssues) {
        this.linkIssues = linkIssues;
    }
}
