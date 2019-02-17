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

package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.ComponentBean;
import com.github.cschulc.jirarestservice.domain.ProjectBean;
import com.github.cschulc.jirarestservice.domain.VersionBean;
import com.github.cschulc.jirarestservice.domain.meta.MetaBean;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class ProjectRestServiceTest extends BaseTest {

    @Test
    public void testGetProjectByKey() throws ExecutionException, InterruptedException {
        final Future<ProjectBean> future = restService.getProjectRestService().getProjectByKey(PROJECT_TO_SEARCH, "type");
        final ProjectBean project = future.get();
        Assert.assertNotNull(project);
        Assert.assertEquals(PROJECT_TO_SEARCH, project.getKey());
    }

    @Test
    public void testGetAllProjects() throws  ExecutionException, InterruptedException {
        final Future<List<ProjectBean>> future = restService.getProjectRestService().getAllProjects();
        final List<ProjectBean> projects = future.get();
        Assert.assertNotNull(projects);
        Assert.assertFalse(projects.isEmpty());
    }

    @Test
    public void testGetProjectVersions() throws  ExecutionException, InterruptedException {
        final Future<List<VersionBean>> future = restService.getProjectRestService().getProjectVersions(PROJECT_TO_SEARCH);
        final List<VersionBean> versions = future.get();
        Assert.assertNotNull(versions);
        Assert.assertFalse(versions.isEmpty());
    }

    @Test
    public void testGetProjectComponents() throws ExecutionException, InterruptedException {
        final Future<List<ComponentBean>> future = restService.getProjectRestService().getProjectComponents(PROJECT_TO_SEARCH);
        final List<ComponentBean> components = future.get();
        Assert.assertNotNull(components);
        Assert.assertFalse(components.isEmpty());
    }

    @Test
    public void testGetIssueTypesMetaForProject() throws ExecutionException, InterruptedException {
        Future<MetaBean> future = restService.getProjectRestService().getIssueTypesMetaForProject(PROJECT_TO_SEARCH);
        MetaBean meta = future.get();
        Assert.assertNotNull(meta);
    }

    @Test
    public void testGetAllProjectCategories(){

    }
}
