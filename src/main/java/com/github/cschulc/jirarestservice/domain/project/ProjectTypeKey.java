package com.github.cschulc.jirarestservice.domain.project;

/**
 * The project type, which dictates the application-specific feature set. Required when creating a project.
 * Not applicable for the Update project resource. See the Update project type resource instead.
 *
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 29.06.2018
 * Time: 12:35
 */
public enum ProjectTypeKey {
    SOFTWARE("software"),
    SERVICE_DESK("service_desk"),
    BUSINESS("business");

    private final String key;

    ProjectTypeKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
