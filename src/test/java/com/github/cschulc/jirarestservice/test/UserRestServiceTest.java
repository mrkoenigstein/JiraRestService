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

import com.github.cschulc.jirarestservice.domain.user.CreateUserBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.github.cschulc.jirarestservice.domain.permission.MyPermissionsBean;
import com.github.cschulc.jirarestservice.misc.JiraRestException;
import org.testng.Assert;
import org.testng.annotations.Ignore;
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
    public void testGetUserByUsername() throws ExecutionException, InterruptedException {
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
        Assert.assertEquals(users.size(),2);
    }

    @Test
    public void testGetAssignableUsersForIssue() throws IOException, ExecutionException, InterruptedException, JiraRestException {
        Future<List<UserBean>> future = restService.getUserRestService().getAssignableUsersForIssue(ISSUEKEY_TO_SEARCH, null, null);
        final List<UserBean> users = future.get();
        Assert.assertNotNull(users);
        Assert.assertEquals(users.size(),2);
    }

    @Test
    public void testGetMyPermissions() throws ExecutionException, InterruptedException {
        Future<MyPermissionsBean> future = restService.getUserRestService().getMyPermissions();
        MyPermissionsBean myPermissions = future.get();
        Assert.assertNotNull(myPermissions);
    }

    /**
     * This Test can only run once because you can only create one user with a unique name
     * TODO randomise the Name
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    @Ignore
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
