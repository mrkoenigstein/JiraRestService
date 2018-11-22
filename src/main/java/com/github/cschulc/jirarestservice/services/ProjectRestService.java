package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.ComponentBean;
import com.github.cschulc.jirarestservice.domain.ProjectBean;
import com.github.cschulc.jirarestservice.domain.VersionBean;
import com.github.cschulc.jirarestservice.domain.meta.MetaBean;
import com.github.cschulc.jirarestservice.domain.project.CreateProjectBean;
import com.github.cschulc.jirarestservice.domain.project.ProjectCategoryBean;

import java.util.List;
import java.util.concurrent.Future;

public interface ProjectRestService {

    /**
     * Returns a list of all projects the logged in UserBean can see..
     *
     * @return list of projects
     */
    Future<List<ProjectBean>> getAllProjects();

    /**
     * Returns a full representation of the project for the given key.
     *
     * @param projectKey = the project key
     * @return all informations for the project
     */
    Future<ProjectBean> getProjectByKey(final String projectKey, String expand);

    /**
     * Returns a list of all versions for a project.
     *
     * @param projectKey = the project key
     * @return list of versions
     */
    Future<List<VersionBean>> getProjectVersions(final String projectKey);


    /**
     * Returns a list of all components for a project.
     *
     * @param projectKey = the project key
     * @return list of components
     */
    Future<List<ComponentBean>> getProjectComponents(final String projectKey);


    /**
     * Return the MetaBean Data for the IssueTypes of a ProjectBean. This includes all possible IssueTypes and the FieldsBean including the AllowedValues
     *
     * @param projectKey The Key for the project
     * @return A {@link MetaBean} Bean with all Infos
     */
    Future<MetaBean> getIssueTypesMetaForProject(final String projectKey);


    /**
     * Creates a new ProjectBean
     *
     * @param project The ProjectBean to create
     * @return The new ProjectBean with the given Id
     */
    Future<ProjectBean> createProject(CreateProjectBean project);

    /**
     * Create a project category via POST.
     *
     * @param name The name of the projectcategory
     * @param description The Description of the projectcategory
     * @return The create {@link ProjectCategoryBean}
     */
    Future<ProjectCategoryBean> createProjectCategory(String name, String description);

    /**
     * Returns all project categories
     *
     * @return A {@link List} of {@link ProjectCategoryBean}
     */
    Future<List<ProjectCategoryBean>> getAllProjectCategories();

}
