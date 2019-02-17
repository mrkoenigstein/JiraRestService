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
