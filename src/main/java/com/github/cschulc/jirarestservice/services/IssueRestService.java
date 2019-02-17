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

package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.*;
import com.github.cschulc.jirarestservice.domain.update.IssueUpdateBean;
import com.github.cschulc.jirarestservice.misc.JiraRestException;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.Future;

/**
 * The IssueRestService provides all RestService-Actions for Jira Issues
 */
public interface IssueRestService {

    /**
     * Create a new issue
     *
     * @param issue = the issue
     * @return IssueResponseBean
     */
    Future<IssueResponseBean> createIssue(IssueBean issue);

    /**
     * Returns a full representation of the issue for the given issue key.
     *
     * @param issueKey = issue key
     * @return all informations for the issue or null if the issue did not exist
     */
    Future<IssueBean> getIssueByKey(String issueKey);

    /**
     * update FieldEnum of an IssueBean
     */
    Future<IssueBean> updateIssue(String issueKey, IssueUpdateBean issueUpdate);

    /**
     * Return a IssueBean with the given FieldEnum and Expand FieldsBean.
     *
     * @param issueKey The IssueKey
     * @param fields   The field you want to return.
     * @param expand   The FieldEnum which must expand.
     * @return IssueBean or null if the issue did not exist
     */
    Future<IssueBean> getIssueByKey(String issueKey, List<String> fields, List<String> expand);

    /**
     * Get Attachement as byte Array, or null
     *
     * @param uri = the uri of the resource
     * @return byte[] or null
     */
    Future<Byte[]> getAttachment(URI uri);


    /**
     * Get AttachmentBean Information for an attachment by id
     *
     * @param id the id of the attachment
     * @return Future with {@link AttachmentBean}
     */
    Future<AttachmentBean> getAttachment(String id);

    /**
     * Save AttachmentBean to IssueBean
     */
    Future<List<AttachmentBean>> saveAttachmentToIssue(String issuekey, File... file);

    /**
     * Returns true if the worklog is successfully transfered to the IssueBean.
     * <p/>
     * <p>This method is for merging log time for an IssueBean.
     *
     * @param issueKey = the issue key
     * @param worklog  = the one which would be transfered
     * @return created state
     */
    boolean transferWorklogInIssue(String issueKey,
                                   WorklogBean worklog) throws JiraRestException, IOException, URISyntaxException;

    /**
     * Returns true if the transition update on an IssueBean success.
     *
     * @param issueKey     = the issue key
     * @param transitionId = the transition id
     * @return success state
     */
    boolean updateIssueTransitionByKey(String issueKey, int transitionId) throws JiraRestException, IOException, URISyntaxException;

    /**
     * Returns available transitions for an IssueBean in a map with transition id and properties.
     *
     * @param issueKey = the issue key
     * @return List of TransitionBean
     */
    Future<List<TransitionBean>> getIssueTransitionsByKey(String issueKey);

    /**
     * Returns a summarized representation of all comments for the given issue.
     *
     * @param issueKey = issue key
     * @return summarized representation of all comments
     */
    Future<CommentsBean> getCommentsByIssue(String issueKey);

    /**
     * Add comment to issue.
     *  @param issueKey = issue key
     * @param comment  = comment to add
     */
    Future<Boolean> addCommentToIssue(String issueKey, CommentBean comment) throws JiraRestException, URISyntaxException, IOException;
}
