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

package com.github.cschulc.jirarestservice.domain.project;

/**
 * A prebuilt configuration for a project. The type of the projectTemplateKey must match with the type of the projectTypeKey.
 * Required when creating a project. Not applicable for the Update project resource.
 *
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 29.06.2018
 * Time: 12:28
 */
public enum ProjectTemplateKey {
    CORE_CONTENT_MANAGMANET("com.atlassian.jira-core-project-templates:jira-core-simplified-content-management"),
    CORE_DOCUMENT_APPROVAL("com.atlassian.jira-core-project-templates:jira-core-simplified-document-approval"),
    CORE_LEAD_TRACKING("com.atlassian.jira-core-project-templates:jira-core-simplified-lead-tracking"),
    CORE_PROCESS_CONTROL("com.atlassian.jira-core-project-templates:jira-core-simplified-process-control"),
    CORE_PROCUREMENT("com.atlassian.jira-core-project-templates:jira-core-simplified-procurement"),
    CORE_PROJECT_MANAGMENT("com.atlassian.jira-core-project-templates:jira-core-simplified-project-management"),
    CORE_RECRUITMENT("com.atlassian.jira-core-project-templates:jira-core-simplified-recruitment"),
    CORE_TASK_TRACKING("com.atlassian.jira-core-project-templates:jira-core-simplified-task-tracking"),
    SERVICEDESK_INTERNAL("com.atlassian.servicedesk:simplified-internal-service-desk"),
    SERVICEDESK_EXTERNAL("com.atlassian.servicedesk:simplified-external-service-desk"),
    SERVICEDESK_IT("com.atlassian.servicedesk:simplified-it-service-desk"),
    GREENHOPPER_AGILITY("com.pyxis.greenhopper.jira:gh-simplified-agility"),
    GREENHOPPER_BASIC("com.pyxis.greenhopper.jira:gh-simplified-basic"),
    GREENHOPPER_SCRUM("com.pyxis.greenhopper.jira:gh-simplified-scrum"),
    GREENHOPPER_KANBAN("com.pyxis.greenhopper.jira:gh-simplified-kanban");


    private final String key;

    ProjectTemplateKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
