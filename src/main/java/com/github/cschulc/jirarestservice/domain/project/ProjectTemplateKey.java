package com.github.cschulc.jirarestservice.domain.project;

/**
 * A prebuilt configuration for a project. The type of the projectTemplateKey must match with the type of the projectTypeKey.
 * Required when creating a project. Not applicable for the Update project resource.
 *
 * User: Christian Schulze (cschulc@outlook.com)
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
