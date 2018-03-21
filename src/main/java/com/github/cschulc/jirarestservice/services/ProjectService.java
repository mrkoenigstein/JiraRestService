package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.Component;
import com.github.cschulc.jirarestservice.domain.Project;
import com.github.cschulc.jirarestservice.domain.Version;
import com.github.cschulc.jirarestservice.domain.meta.Meta;

import java.util.List;
import java.util.concurrent.Future;

public interface ProjectService {

    /**
     * Returns a list of all projects the logged in User can see..
     *
     * @return list of projects
     */
    Future<List<Project>> getAllProjects();

    /**
     * Returns a full representation of the project for the given key.
     *
     * @param projectKey = the project key
     * @return all informations for the project
     */
    Future<Project> getProjectByKey(final String projectKey);

    /**
     * Returns a list of all versions for a project.
     *
     * @param projectKey = the project key
     * @return list of versions
     */
    Future<List<Version>> getProjectVersions(final String projectKey);


    /**
     * Returns a list of all components for a project.
     *
     * @param projectKey = the project key
     * @return list of components
     */
    Future<List<Component>> getProjectComponents(final String projectKey);


    /**
     * Return the Meta Data for the IssueTypes of a Project. This includes all possible IssueTypes and the Fields including the AllowedValues
     *
     * @param projectKey
     * @return
     */
    Future<Meta> getIssueTypesMetaForProject(final String projectKey);
}
