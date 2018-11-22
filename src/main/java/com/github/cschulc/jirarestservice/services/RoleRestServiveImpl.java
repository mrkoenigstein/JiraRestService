package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.project.ProjectRoleBean;

import java.util.List;
import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 05.07.2018
 * Time: 17:23
 */
public class RoleRestServiveImpl implements RoleRestService {
    @Override
    public Future<List<ProjectRoleBean>> getAllProjectRoles() {
        return null;
    }

    @Override
    public Future<ProjectRoleBean> createProjectRole(String name, String description) {
        return null;
    }

    @Override
    public Future<ProjectRoleBean> getProjectRoleById(int id) {
        return null;
    }
}
