package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.project.ProjectRole;

import java.util.List;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 05.07.2018
 * Time: 17:22
 */
public interface RoleService {

    /**
     * Get all the ProjectRoles available in Jira. Currently this list is global.
     *
     * @return Future with List of {@link ProjectRole}
     */
    Future<List<ProjectRole>> getAllProjectRoles();

    /**
     * Creates a new ProjectRole to be available in Jira. The created role does not have any default actors assigned.
     *
     * @param name The Name of the Role
     * @param description The Description of the Role
     * @return Future with {@link ProjectRole}
     */
    Future<ProjectRole> createProjectRole(String name, String description);

    /**
     * Get a specific ProjectRole available in Jira.
     *
     * @param id The id of the Role
     * @return Future with {@link ProjectRole}
     */
    Future<ProjectRole> getProjectRoleById(int id);


}
