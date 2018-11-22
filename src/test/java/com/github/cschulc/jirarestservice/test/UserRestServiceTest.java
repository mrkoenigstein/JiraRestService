package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.user.CreateUserBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.github.cschulc.jirarestservice.domain.permission.MyPermissionsBean;
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
public class UserRestServiceTest extends BaseTest {

    @Test
    public void testGetUserByUsername() throws IOException, ExecutionException, InterruptedException {
        Future<UserBean> future = restService.getUserRestService().getUserByUsername(USERNAME_TO_SEARCH);
        final UserBean user = future.get();
        Assert.assertNotNull(user);
    }

    @Test
    public void testGetLoggedInUser() throws IOException, ExecutionException, InterruptedException, JiraRestException {
        Future<UserBean> future = restService.getUserRestService().getLoggedInRemoteUser();
        final UserBean user = future.get();
        Assert.assertNotNull(user);
    }

    @Test
    public void testGetAssignableUserForProject() throws IOException, ExecutionException, InterruptedException, JiraRestException {
        Future<List<UserBean>> future = restService.getUserRestService().getAssignableUserForProject(PROJECT_TO_SEARCH, null, null);
        final List<UserBean> users = future.get();
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
    }

    @Test
    public void testGetAssignableUsersForIssue() throws IOException, ExecutionException, InterruptedException, JiraRestException {
        Future<List<UserBean>> future = restService.getUserRestService().getAssignableUsersForIssue(ISSUEKEY_TO_SEARCH, null, null);
        final List<UserBean> users = future.get();
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
    }

    @Test
    public void testGetMyPermissions() throws ExecutionException, InterruptedException {
        Future<MyPermissionsBean> future = restService.getUserRestService().getMyPermissions();
        MyPermissionsBean myPermissions = future.get();
        Assert.assertNotNull(myPermissions);
    }

    @Test
    public void testCreateUser() throws ExecutionException, InterruptedException {
        CreateUserBean createUser = new CreateUserBean();
        createUser.setName("Jane Doe");
        createUser.setPassword("1234");
        createUser.setEmailAddress("janedoe@test.de");
        createUser.setDisplayName("Jane Doe the First");
        createUser.getApplicationKeys().add("jira-core");
        Future<UserBean> future = restService.getUserRestService().createUser(createUser);
        UserBean user = future.get();
        Assert.assertNotNull(user);
    }

    @Test
    public void testFindUsers() throws ExecutionException, InterruptedException {
        Future<List<UserBean>> future = restService.getUserRestService().findUsers(true, false, 100, null, 0, ".");
        List<UserBean> users = future.get();
        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());
    }
}
