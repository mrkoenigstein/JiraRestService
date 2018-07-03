package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.Component;
import com.github.cschulc.jirarestservice.domain.Project;
import com.github.cschulc.jirarestservice.domain.Version;
import com.github.cschulc.jirarestservice.domain.meta.Meta;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class ProjectServiceTest extends BaseTest {

    @Test
    public void testGetProjectByKey() throws ExecutionException, InterruptedException {
        final Future<Project> future = restService.getProjectService().getProjectByKey(PROJECT_TO_SEARCH);
        final Project project = future.get();
        Assert.assertNotNull(project);
        Assert.assertEquals(PROJECT_TO_SEARCH, project.getKey());
    }

    @Test
    public void testGetAllProjects() throws  ExecutionException, InterruptedException {
        final Future<List<Project>> future = restService.getProjectService().getAllProjects();
        final List<Project> projects = future.get();
        Assert.assertNotNull(projects);
        Assert.assertFalse(projects.isEmpty());
    }

    @Test
    public void testGetProjectVersions() throws  ExecutionException, InterruptedException {
        final Future<List<Version>> future = restService.getProjectService().getProjectVersions(PROJECT_TO_SEARCH);
        final List<Version> versions = future.get();
        Assert.assertNotNull(versions);
        Assert.assertTrue(versions.isEmpty());
    }

    @Test
    public void testGetProjectComponents() throws ExecutionException, InterruptedException {
        final Future<List<Component>> future = restService.getProjectService().getProjectComponents(PROJECT_TO_SEARCH);
        final List<Component> components = future.get();
        Assert.assertNotNull(components);
        Assert.assertTrue(components.isEmpty());
    }

    @Test
    public void testGetIssueTypesMetaForProject() throws ExecutionException, InterruptedException {
        Future<Meta> future = restService.getProjectService().getIssueTypesMetaForProject(PROJECT_TO_SEARCH);
        Meta meta = future.get();
        Assert.assertNotNull(meta);
    }

    @Test
    public void testGetAllProjectCategories(){

    }
}
