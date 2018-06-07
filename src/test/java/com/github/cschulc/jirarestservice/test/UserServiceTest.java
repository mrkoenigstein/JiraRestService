package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.User;
import com.github.cschulc.jirarestservice.domain.permission.MyPermissions;
import com.github.cschulc.jirarestservice.misc.JiraRestException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class UserServiceTest extends BaseTest {

    @Test
    public void testGetUserByUsername() throws IOException, ExecutionException, InterruptedException {
        Future<User> future = restService.getUserService().getUserByUsername(USERNAME_TO_SEARCH);
        final User user = future.get();
        Assert.assertNotNull(user);
    }

    @Test
    public void testGetLoggedInUser() throws IOException, ExecutionException, InterruptedException, JiraRestException {
        Future<User> future = restService.getUserService().getLoggedInRemoteUser();
        final User user = future.get();
        Assert.assertNotNull(user);
    }

    @Test
    public void testGetAssignableUserForProject() throws IOException, ExecutionException, InterruptedException, JiraRestException {
        Future<List<User>> future = restService.getUserService().getAssignableUserForProject(PROJECT_TO_SEARCH, null, null);
        final List<User> users = future.get();
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
    }

    @Test
    public void testGetAssignableUsersForIssue() throws IOException, ExecutionException, InterruptedException, JiraRestException {
        Future<List<User>> future = restService.getUserService().getAssignableUsersForIssue(ISSUEKEY_TO_SEARCH, null, null);
        final List<User> users = future.get();
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
    }

    @Test
    public void testGetMyPermissions() throws ExecutionException, InterruptedException {
        Future<MyPermissions> future = restService.getUserService().getMyPermissions();
        MyPermissions myPermissions = future.get();
        Assert.assertNotNull(myPermissions);
    }
}
