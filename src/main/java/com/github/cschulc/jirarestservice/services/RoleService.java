package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.project.ProjectRoleBean;

import java.util.List;
import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 05.07.2018
 * Time: 17:22
 */
public interface RoleService {

    /**
     * Get all the ProjectRoles available in Jira. Currently this list is global.
     *
     * @return Future with List of {@link ProjectRoleBean}
     */
    Future<List<ProjectRoleBean>> getAllProjectRoles();

    /**
     * Creates a new ProjectRoleBean to be available in Jira. The created role does not have any default actors assigned.
     *
     * @param name The Name of the Role
     * @param description The Description of the Role
     * @return Future with {@link ProjectRoleBean}
     */
    Future<ProjectRoleBean> createProjectRole(String name, String description);

    /**
     * Get a specific ProjectRoleBean available in Jira.
     *
     * @param id The id of the Role
     * @return Future with {@link ProjectRoleBean}
     */
    Future<ProjectRoleBean> getProjectRoleById(int id);


}
