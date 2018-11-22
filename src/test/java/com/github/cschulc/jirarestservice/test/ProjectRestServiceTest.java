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
        Assert.assertTrue(versions.isEmpty());
    }

    @Test
    public void testGetProjectComponents() throws ExecutionException, InterruptedException {
        final Future<List<ComponentBean>> future = restService.getProjectRestService().getProjectComponents(PROJECT_TO_SEARCH);
        final List<ComponentBean> components = future.get();
        Assert.assertNotNull(components);
        Assert.assertTrue(components.isEmpty());
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
