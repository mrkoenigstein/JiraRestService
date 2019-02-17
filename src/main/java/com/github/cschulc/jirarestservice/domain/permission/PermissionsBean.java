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

package com.github.cschulc.jirarestservice.domain.permission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class PermissionsBean {

    @SerializedName("VIEW_WORKFLOW_READONLY")
    @Expose
    private UserPermissionBean viewWorkflowReadonly;

    @SerializedName("CREATE_ISSUES")
    @Expose
    private UserPermissionBean createIssues;

    @SerializedName("BULK_CHANGE")
    @Expose
    private UserPermissionBean bulkChange;

    @SerializedName("CREATE_ATTACHMENT")
    @Expose
    private UserPermissionBean createAttachment;

    @SerializedName("DELETE_OWN_COMMENTS")
    @Expose
    private UserPermissionBean deleteOwnComments;

    @SerializedName("WORK_ON_ISSUES")
    @Expose
    private UserPermissionBean workOnIssues;

    @SerializedName("PROJECT_ADMIN")
    @Expose
    private UserPermissionBean projectAdmin;

    @SerializedName("COMMENT_EDIT_ALL")
    @Expose
    private UserPermissionBean commentEditAll;

    @SerializedName("ATTACHMENT_DELETE_OWN")
    @Expose
    private UserPermissionBean attachmentDeleteOwn;

    @SerializedName("WORKLOG_DELETE_OWN")
    @Expose
    private UserPermissionBean worklogDeleteOwn;

    @SerializedName("CLOSE_ISSUE")
    @Expose
    private UserPermissionBean closeIssue;

    @SerializedName("MANAGE_WATCHER_LIST")
    @Expose
    private UserPermissionBean manageWatcherList;

    @SerializedName("VIEW_VOTERS_AND_WATCHERS")
    @Expose
    private UserPermissionBean viewVotersAndWatchers;

    @SerializedName("ADD_COMMENTS")
    @Expose
    private UserPermissionBean addComments;

    @SerializedName("COMMENT_DELETE_ALL")
    @Expose
    private UserPermissionBean commentDeleteAll;

    @SerializedName("CREATE_ISSUE")
    @Expose
    private UserPermissionBean createIssue;

    @SerializedName("DELETE_OWN_ATTACHMENTS")
    @Expose
    private UserPermissionBean deleteOwnAttachments;

    @SerializedName("ASSIGN_ISSUE")
    @Expose
    private UserPermissionBean assignIssue;

    @SerializedName("LINK_ISSUE")
    @Expose
    private UserPermissionBean linkIssue;

    @SerializedName("EDIT_OWN_WORKLOGS")
    @Expose
    private UserPermissionBean editOwnWorklogs;

    @SerializedName("CREATE_ATTACHMENTS")
    @Expose
    private UserPermissionBean createAttachments;

    @SerializedName("EDIT_ALL_WORKLOGS")
    @Expose
    private UserPermissionBean editAllWorklogs;

    @SerializedName("SCHEDULE_ISSUE")
    @Expose
    private UserPermissionBean scheduleIssue;

    @SerializedName("CLOSE_ISSUES")
    @Expose
    private UserPermissionBean closeIssues;

    @SerializedName("SET_ISSUE_SECURITY")
    @Expose
    private UserPermissionBean setIssueSecurity;

    @SerializedName("SCHEDULE_ISSUES")
    @Expose
    private UserPermissionBean scheduleIssues;

    @SerializedName("WORKLOG_DELETE_ALL")
    @Expose
    private UserPermissionBean worklogDeleteAll;

    @SerializedName("COMMENT_DELETE_OWN")
    @Expose
    private UserPermissionBean commentDeleteOwn;

    @SerializedName("ADMINISTER_PROJECTS")
    @Expose
    private UserPermissionBean administerProjects;

    @SerializedName("DELETE_ALL_COMMENTS")
    @Expose
    private UserPermissionBean deleteAllComments;

    @SerializedName("RESOLVE_ISSUES")
    @Expose
    private UserPermissionBean resolveIssues;

    @SerializedName("VIEW_READONLY_WORKFLOW")
    @Expose
    private UserPermissionBean viewReadonlyWorkflow;

    @SerializedName("ADMINISTER")
    @Expose
    private UserPermissionBean administer;

    @SerializedName("MOVE_ISSUES")
    @Expose
    private UserPermissionBean moveIssues;

    @SerializedName("TRANSITION_ISSUES")
    @Expose
    private UserPermissionBean transitionIssues;

    @SerializedName("SYSTEM_ADMIN")
    @Expose
    private UserPermissionBean systemAdmin;

    @SerializedName("DELETE_OWN_WORKLOGS")
    @Expose
    private UserPermissionBean deleteOwnWorklogs;

    @SerializedName("BROWSE")
    @Expose
    private UserPermissionBean brwose;

    @SerializedName("EDIT_ISSUE")
    @Expose
    private UserPermissionBean editIssue;

    @SerializedName("MODIFY_REPORTER")
    @Expose
    private UserPermissionBean modifyReporter;

    @SerializedName("EDIT_ISSUES")
    @Expose
    private UserPermissionBean editIssues;

    @SerializedName("MANAGE_WATCHERS")
    @Expose
    private UserPermissionBean manageWatchers;

    @SerializedName("EDIT_OWN_COMMENTS")
    @Expose
    private UserPermissionBean editOwnComments;

    @SerializedName("ASSIGN_ISSUES")
    @Expose
    private UserPermissionBean assignIssues;

    @SerializedName("BROWSE_PROJECTS")
    @Expose
    private UserPermissionBean browseProjects;

    @SerializedName("VIEW_VERSION_CONTROL")
    @Expose
    private UserPermissionBean viewVersionControl;

    @SerializedName("WORK_ISSUE")
    @Expose
    private UserPermissionBean workIssue;

    @SerializedName("COMMENT_ISSUE")
    @Expose
    private UserPermissionBean commentIssue;

    @SerializedName("WORKLOG_EDIT_ALL")
    @Expose
    private UserPermissionBean worklogEditAll;

    @SerializedName("EDIT_ALL_COMMENTS")
    @Expose
    private UserPermissionBean editAllComments;

    @SerializedName("DELETE_ISSUE")
    @Expose
    private UserPermissionBean deleteIssue;

    @SerializedName("USER_PICKER")
    @Expose
    private UserPermissionBean userPicker;

    @SerializedName("CREATE_SHARED_OBJECTS")
    @Expose
    private UserPermissionBean createSharedObjects;

    @SerializedName("ATTACHMENT_DELETE_ALL")
    @Expose
    private UserPermissionBean attachmentDeleteAll;

    @SerializedName("DELETE_ISSUES")
    @Expose
    private UserPermissionBean deleteIssues;

    @SerializedName("MANAGE_GROUP_FILTER_SUBSCRIPTIONS")
    @Expose
    private UserPermissionBean manageGroupFilterSubscriptions;

    @SerializedName("RESOLVE_ISSUE")
    @Expose
    private UserPermissionBean resolveIssue;

    @SerializedName("ASSIGNABLE_USER")
    @Expose
    private UserPermissionBean assignableUser;

    @SerializedName("TRANSITION_ISSUE")
    @Expose
    private UserPermissionBean transitionIssue;

    @SerializedName("COMMENT_EDIT_OWN")
    @Expose
    private UserPermissionBean commentEditOwn;

    @SerializedName("MOVE_ISSUE")
    @Expose
    private UserPermissionBean moveIssue;

    @SerializedName("WORKLOG_EDIT_OWN")
    @Expose
    private UserPermissionBean worklogEditOwn;

    @SerializedName("DELETE_ALL_WORKLOGS")
    @Expose
    private UserPermissionBean deleteAllWorklogs;

    @SerializedName("LINK_ISSUES")
    @Expose
    private UserPermissionBean linkIssues;

    public UserPermissionBean getViewWorkflowReadonly() {
        return viewWorkflowReadonly;
    }

    public void setViewWorkflowReadonly(UserPermissionBean viewWorkflowReadonly) {
        this.viewWorkflowReadonly = viewWorkflowReadonly;
    }

    public UserPermissionBean getCreateIssues() {
        return createIssues;
    }

    public void setCreateIssues(UserPermissionBean createIssues) {
        this.createIssues = createIssues;
    }

    public UserPermissionBean getBulkChange() {
        return bulkChange;
    }

    public void setBulkChange(UserPermissionBean bulkChange) {
        this.bulkChange = bulkChange;
    }

    public UserPermissionBean getCreateAttachment() {
        return createAttachment;
    }

    public void setCreateAttachment(UserPermissionBean createAttachment) {
        this.createAttachment = createAttachment;
    }

    public UserPermissionBean getDeleteOwnComments() {
        return deleteOwnComments;
    }

    public void setDeleteOwnComments(UserPermissionBean deleteOwnComments) {
        this.deleteOwnComments = deleteOwnComments;
    }

    public UserPermissionBean getWorkOnIssues() {
        return workOnIssues;
    }

    public void setWorkOnIssues(UserPermissionBean workOnIssues) {
        this.workOnIssues = workOnIssues;
    }

    public UserPermissionBean getProjectAdmin() {
        return projectAdmin;
    }

    public void setProjectAdmin(UserPermissionBean projectAdmin) {
        this.projectAdmin = projectAdmin;
    }

    public UserPermissionBean getCommentEditAll() {
        return commentEditAll;
    }

    public void setCommentEditAll(UserPermissionBean commentEditAll) {
        this.commentEditAll = commentEditAll;
    }

    public UserPermissionBean getAttachmentDeleteOwn() {
        return attachmentDeleteOwn;
    }

    public void setAttachmentDeleteOwn(UserPermissionBean attachmentDeleteOwn) {
        this.attachmentDeleteOwn = attachmentDeleteOwn;
    }

    public UserPermissionBean getWorklogDeleteOwn() {
        return worklogDeleteOwn;
    }

    public void setWorklogDeleteOwn(UserPermissionBean worklogDeleteOwn) {
        this.worklogDeleteOwn = worklogDeleteOwn;
    }

    public UserPermissionBean getCloseIssue() {
        return closeIssue;
    }

    public void setCloseIssue(UserPermissionBean closeIssue) {
        this.closeIssue = closeIssue;
    }

    public UserPermissionBean getManageWatcherList() {
        return manageWatcherList;
    }

    public void setManageWatcherList(UserPermissionBean manageWatcherList) {
        this.manageWatcherList = manageWatcherList;
    }

    public UserPermissionBean getViewVotersAndWatchers() {
        return viewVotersAndWatchers;
    }

    public void setViewVotersAndWatchers(UserPermissionBean viewVotersAndWatchers) {
        this.viewVotersAndWatchers = viewVotersAndWatchers;
    }

    public UserPermissionBean getAddComments() {
        return addComments;
    }

    public void setAddComments(UserPermissionBean addComments) {
        this.addComments = addComments;
    }

    public UserPermissionBean getCommentDeleteAll() {
        return commentDeleteAll;
    }

    public void setCommentDeleteAll(UserPermissionBean commentDeleteAll) {
        this.commentDeleteAll = commentDeleteAll;
    }

    public UserPermissionBean getCreateIssue() {
        return createIssue;
    }

    public void setCreateIssue(UserPermissionBean createIssue) {
        this.createIssue = createIssue;
    }

    public UserPermissionBean getDeleteOwnAttachments() {
        return deleteOwnAttachments;
    }

    public void setDeleteOwnAttachments(UserPermissionBean deleteOwnAttachments) {
        this.deleteOwnAttachments = deleteOwnAttachments;
    }

    public UserPermissionBean getAssignIssue() {
        return assignIssue;
    }

    public void setAssignIssue(UserPermissionBean assignIssue) {
        this.assignIssue = assignIssue;
    }

    public UserPermissionBean getLinkIssue() {
        return linkIssue;
    }

    public void setLinkIssue(UserPermissionBean linkIssue) {
        this.linkIssue = linkIssue;
    }

    public UserPermissionBean getEditOwnWorklogs() {
        return editOwnWorklogs;
    }

    public void setEditOwnWorklogs(UserPermissionBean editOwnWorklogs) {
        this.editOwnWorklogs = editOwnWorklogs;
    }

    public UserPermissionBean getCreateAttachments() {
        return createAttachments;
    }

    public void setCreateAttachments(UserPermissionBean createAttachments) {
        this.createAttachments = createAttachments;
    }

    public UserPermissionBean getEditAllWorklogs() {
        return editAllWorklogs;
    }

    public void setEditAllWorklogs(UserPermissionBean editAllWorklogs) {
        this.editAllWorklogs = editAllWorklogs;
    }

    public UserPermissionBean getScheduleIssue() {
        return scheduleIssue;
    }

    public void setScheduleIssue(UserPermissionBean scheduleIssue) {
        this.scheduleIssue = scheduleIssue;
    }

    public UserPermissionBean getCloseIssues() {
        return closeIssues;
    }

    public void setCloseIssues(UserPermissionBean closeIssues) {
        this.closeIssues = closeIssues;
    }

    public UserPermissionBean getSetIssueSecurity() {
        return setIssueSecurity;
    }

    public void setSetIssueSecurity(UserPermissionBean setIssueSecurity) {
        this.setIssueSecurity = setIssueSecurity;
    }

    public UserPermissionBean getScheduleIssues() {
        return scheduleIssues;
    }

    public void setScheduleIssues(UserPermissionBean scheduleIssues) {
        this.scheduleIssues = scheduleIssues;
    }

    public UserPermissionBean getWorklogDeleteAll() {
        return worklogDeleteAll;
    }

    public void setWorklogDeleteAll(UserPermissionBean worklogDeleteAll) {
        this.worklogDeleteAll = worklogDeleteAll;
    }

    public UserPermissionBean getCommentDeleteOwn() {
        return commentDeleteOwn;
    }

    public void setCommentDeleteOwn(UserPermissionBean commentDeleteOwn) {
        this.commentDeleteOwn = commentDeleteOwn;
    }

    public UserPermissionBean getAdministerProjects() {
        return administerProjects;
    }

    public void setAdministerProjects(UserPermissionBean administerProjects) {
        this.administerProjects = administerProjects;
    }

    public UserPermissionBean getDeleteAllComments() {
        return deleteAllComments;
    }

    public void setDeleteAllComments(UserPermissionBean deleteAllComments) {
        this.deleteAllComments = deleteAllComments;
    }

    public UserPermissionBean getResolveIssues() {
        return resolveIssues;
    }

    public void setResolveIssues(UserPermissionBean resolveIssues) {
        this.resolveIssues = resolveIssues;
    }

    public UserPermissionBean getViewReadonlyWorkflow() {
        return viewReadonlyWorkflow;
    }

    public void setViewReadonlyWorkflow(UserPermissionBean viewReadonlyWorkflow) {
        this.viewReadonlyWorkflow = viewReadonlyWorkflow;
    }

    public UserPermissionBean getAdminister() {
        return administer;
    }

    public void setAdminister(UserPermissionBean administer) {
        this.administer = administer;
    }

    public UserPermissionBean getMoveIssues() {
        return moveIssues;
    }

    public void setMoveIssues(UserPermissionBean moveIssues) {
        this.moveIssues = moveIssues;
    }

    public UserPermissionBean getTransitionIssues() {
        return transitionIssues;
    }

    public void setTransitionIssues(UserPermissionBean transitionIssues) {
        this.transitionIssues = transitionIssues;
    }

    public UserPermissionBean getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(UserPermissionBean systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public UserPermissionBean getDeleteOwnWorklogs() {
        return deleteOwnWorklogs;
    }

    public void setDeleteOwnWorklogs(UserPermissionBean deleteOwnWorklogs) {
        this.deleteOwnWorklogs = deleteOwnWorklogs;
    }

    public UserPermissionBean getBrwose() {
        return brwose;
    }

    public void setBrwose(UserPermissionBean brwose) {
        this.brwose = brwose;
    }

    public UserPermissionBean getEditIssue() {
        return editIssue;
    }

    public void setEditIssue(UserPermissionBean editIssue) {
        this.editIssue = editIssue;
    }

    public UserPermissionBean getModifyReporter() {
        return modifyReporter;
    }

    public void setModifyReporter(UserPermissionBean modifyReporter) {
        this.modifyReporter = modifyReporter;
    }

    public UserPermissionBean getEditIssues() {
        return editIssues;
    }

    public void setEditIssues(UserPermissionBean editIssues) {
        this.editIssues = editIssues;
    }

    public UserPermissionBean getManageWatchers() {
        return manageWatchers;
    }

    public void setManageWatchers(UserPermissionBean manageWatchers) {
        this.manageWatchers = manageWatchers;
    }

    public UserPermissionBean getEditOwnComments() {
        return editOwnComments;
    }

    public void setEditOwnComments(UserPermissionBean editOwnComments) {
        this.editOwnComments = editOwnComments;
    }

    public UserPermissionBean getAssignIssues() {
        return assignIssues;
    }

    public void setAssignIssues(UserPermissionBean assignIssues) {
        this.assignIssues = assignIssues;
    }

    public UserPermissionBean getBrowseProjects() {
        return browseProjects;
    }

    public void setBrowseProjects(UserPermissionBean browseProjects) {
        this.browseProjects = browseProjects;
    }

    public UserPermissionBean getViewVersionControl() {
        return viewVersionControl;
    }

    public void setViewVersionControl(UserPermissionBean viewVersionControl) {
        this.viewVersionControl = viewVersionControl;
    }

    public UserPermissionBean getWorkIssue() {
        return workIssue;
    }

    public void setWorkIssue(UserPermissionBean workIssue) {
        this.workIssue = workIssue;
    }

    public UserPermissionBean getCommentIssue() {
        return commentIssue;
    }

    public void setCommentIssue(UserPermissionBean commentIssue) {
        this.commentIssue = commentIssue;
    }

    public UserPermissionBean getWorklogEditAll() {
        return worklogEditAll;
    }

    public void setWorklogEditAll(UserPermissionBean worklogEditAll) {
        this.worklogEditAll = worklogEditAll;
    }

    public UserPermissionBean getEditAllComments() {
        return editAllComments;
    }

    public void setEditAllComments(UserPermissionBean editAllComments) {
        this.editAllComments = editAllComments;
    }

    public UserPermissionBean getDeleteIssue() {
        return deleteIssue;
    }

    public void setDeleteIssue(UserPermissionBean deleteIssue) {
        this.deleteIssue = deleteIssue;
    }

    public UserPermissionBean getUserPicker() {
        return userPicker;
    }

    public void setUserPicker(UserPermissionBean userPicker) {
        this.userPicker = userPicker;
    }

    public UserPermissionBean getCreateSharedObjects() {
        return createSharedObjects;
    }

    public void setCreateSharedObjects(UserPermissionBean createSharedObjects) {
        this.createSharedObjects = createSharedObjects;
    }

    public UserPermissionBean getAttachmentDeleteAll() {
        return attachmentDeleteAll;
    }

    public void setAttachmentDeleteAll(UserPermissionBean attachmentDeleteAll) {
        this.attachmentDeleteAll = attachmentDeleteAll;
    }

    public UserPermissionBean getDeleteIssues() {
        return deleteIssues;
    }

    public void setDeleteIssues(UserPermissionBean deleteIssues) {
        this.deleteIssues = deleteIssues;
    }

    public UserPermissionBean getManageGroupFilterSubscriptions() {
        return manageGroupFilterSubscriptions;
    }

    public void setManageGroupFilterSubscriptions(UserPermissionBean manageGroupFilterSubscriptions) {
        this.manageGroupFilterSubscriptions = manageGroupFilterSubscriptions;
    }

    public UserPermissionBean getResolveIssue() {
        return resolveIssue;
    }

    public void setResolveIssue(UserPermissionBean resolveIssue) {
        this.resolveIssue = resolveIssue;
    }

    public UserPermissionBean getAssignableUser() {
        return assignableUser;
    }

    public void setAssignableUser(UserPermissionBean assignableUser) {
        this.assignableUser = assignableUser;
    }

    public UserPermissionBean getTransitionIssue() {
        return transitionIssue;
    }

    public void setTransitionIssue(UserPermissionBean transitionIssue) {
        this.transitionIssue = transitionIssue;
    }

    public UserPermissionBean getCommentEditOwn() {
        return commentEditOwn;
    }

    public void setCommentEditOwn(UserPermissionBean commentEditOwn) {
        this.commentEditOwn = commentEditOwn;
    }

    public UserPermissionBean getMoveIssue() {
        return moveIssue;
    }

    public void setMoveIssue(UserPermissionBean moveIssue) {
        this.moveIssue = moveIssue;
    }

    public UserPermissionBean getWorklogEditOwn() {
        return worklogEditOwn;
    }

    public void setWorklogEditOwn(UserPermissionBean worklogEditOwn) {
        this.worklogEditOwn = worklogEditOwn;
    }

    public UserPermissionBean getDeleteAllWorklogs() {
        return deleteAllWorklogs;
    }

    public void setDeleteAllWorklogs(UserPermissionBean deleteAllWorklogs) {
        this.deleteAllWorklogs = deleteAllWorklogs;
    }

    public UserPermissionBean getLinkIssues() {
        return linkIssues;
    }

    public void setLinkIssues(UserPermissionBean linkIssues) {
        this.linkIssues = linkIssues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermissionsBean)) return false;
        PermissionsBean that = (PermissionsBean) o;
        return Objects.equals(viewWorkflowReadonly, that.viewWorkflowReadonly) &&
                Objects.equals(createIssues, that.createIssues) &&
                Objects.equals(bulkChange, that.bulkChange) &&
                Objects.equals(createAttachment, that.createAttachment) &&
                Objects.equals(deleteOwnComments, that.deleteOwnComments) &&
                Objects.equals(workOnIssues, that.workOnIssues) &&
                Objects.equals(projectAdmin, that.projectAdmin) &&
                Objects.equals(commentEditAll, that.commentEditAll) &&
                Objects.equals(attachmentDeleteOwn, that.attachmentDeleteOwn) &&
                Objects.equals(worklogDeleteOwn, that.worklogDeleteOwn) &&
                Objects.equals(closeIssue, that.closeIssue) &&
                Objects.equals(manageWatcherList, that.manageWatcherList) &&
                Objects.equals(viewVotersAndWatchers, that.viewVotersAndWatchers) &&
                Objects.equals(addComments, that.addComments) &&
                Objects.equals(commentDeleteAll, that.commentDeleteAll) &&
                Objects.equals(createIssue, that.createIssue) &&
                Objects.equals(deleteOwnAttachments, that.deleteOwnAttachments) &&
                Objects.equals(assignIssue, that.assignIssue) &&
                Objects.equals(linkIssue, that.linkIssue) &&
                Objects.equals(editOwnWorklogs, that.editOwnWorklogs) &&
                Objects.equals(createAttachments, that.createAttachments) &&
                Objects.equals(editAllWorklogs, that.editAllWorklogs) &&
                Objects.equals(scheduleIssue, that.scheduleIssue) &&
                Objects.equals(closeIssues, that.closeIssues) &&
                Objects.equals(setIssueSecurity, that.setIssueSecurity) &&
                Objects.equals(scheduleIssues, that.scheduleIssues) &&
                Objects.equals(worklogDeleteAll, that.worklogDeleteAll) &&
                Objects.equals(commentDeleteOwn, that.commentDeleteOwn) &&
                Objects.equals(administerProjects, that.administerProjects) &&
                Objects.equals(deleteAllComments, that.deleteAllComments) &&
                Objects.equals(resolveIssues, that.resolveIssues) &&
                Objects.equals(viewReadonlyWorkflow, that.viewReadonlyWorkflow) &&
                Objects.equals(administer, that.administer) &&
                Objects.equals(moveIssues, that.moveIssues) &&
                Objects.equals(transitionIssues, that.transitionIssues) &&
                Objects.equals(systemAdmin, that.systemAdmin) &&
                Objects.equals(deleteOwnWorklogs, that.deleteOwnWorklogs) &&
                Objects.equals(brwose, that.brwose) &&
                Objects.equals(editIssue, that.editIssue) &&
                Objects.equals(modifyReporter, that.modifyReporter) &&
                Objects.equals(editIssues, that.editIssues) &&
                Objects.equals(manageWatchers, that.manageWatchers) &&
                Objects.equals(editOwnComments, that.editOwnComments) &&
                Objects.equals(assignIssues, that.assignIssues) &&
                Objects.equals(browseProjects, that.browseProjects) &&
                Objects.equals(viewVersionControl, that.viewVersionControl) &&
                Objects.equals(workIssue, that.workIssue) &&
                Objects.equals(commentIssue, that.commentIssue) &&
                Objects.equals(worklogEditAll, that.worklogEditAll) &&
                Objects.equals(editAllComments, that.editAllComments) &&
                Objects.equals(deleteIssue, that.deleteIssue) &&
                Objects.equals(userPicker, that.userPicker) &&
                Objects.equals(createSharedObjects, that.createSharedObjects) &&
                Objects.equals(attachmentDeleteAll, that.attachmentDeleteAll) &&
                Objects.equals(deleteIssues, that.deleteIssues) &&
                Objects.equals(manageGroupFilterSubscriptions, that.manageGroupFilterSubscriptions) &&
                Objects.equals(resolveIssue, that.resolveIssue) &&
                Objects.equals(assignableUser, that.assignableUser) &&
                Objects.equals(transitionIssue, that.transitionIssue) &&
                Objects.equals(commentEditOwn, that.commentEditOwn) &&
                Objects.equals(moveIssue, that.moveIssue) &&
                Objects.equals(worklogEditOwn, that.worklogEditOwn) &&
                Objects.equals(deleteAllWorklogs, that.deleteAllWorklogs) &&
                Objects.equals(linkIssues, that.linkIssues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viewWorkflowReadonly, createIssues, bulkChange, createAttachment, deleteOwnComments, workOnIssues, projectAdmin, commentEditAll, attachmentDeleteOwn, worklogDeleteOwn, closeIssue, manageWatcherList, viewVotersAndWatchers, addComments, commentDeleteAll, createIssue, deleteOwnAttachments, assignIssue, linkIssue, editOwnWorklogs, createAttachments, editAllWorklogs, scheduleIssue, closeIssues, setIssueSecurity, scheduleIssues, worklogDeleteAll, commentDeleteOwn, administerProjects, deleteAllComments, resolveIssues, viewReadonlyWorkflow, administer, moveIssues, transitionIssues, systemAdmin, deleteOwnWorklogs, brwose, editIssue, modifyReporter, editIssues, manageWatchers, editOwnComments, assignIssues, browseProjects, viewVersionControl, workIssue, commentIssue, worklogEditAll, editAllComments, deleteIssue, userPicker, createSharedObjects, attachmentDeleteAll, deleteIssues, manageGroupFilterSubscriptions, resolveIssue, assignableUser, transitionIssue, commentEditOwn, moveIssue, worklogEditOwn, deleteAllWorklogs, linkIssues);
    }
}
