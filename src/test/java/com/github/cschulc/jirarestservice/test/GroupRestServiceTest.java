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

import com.github.cschulc.jirarestservice.domain.groups.GroupUsersBean;
import com.github.cschulc.jirarestservice.domain.groups.GroupsBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 26.06.2018
 * Time: 09:47
 */
public class GroupRestServiceTest extends BaseTest {

    @Test
    public void testGetGroups() throws ExecutionException, InterruptedException {
        Future<GroupsBean> future = restService.getGroupRestService().findGroups(null, null, 0, null);
        GroupsBean groups = future.get();
        Assert.assertNotNull(groups);
    }

    @Test
    @Ignore
    public void testGetUserFromGroup() throws ExecutionException, InterruptedException {
        Future<GroupUsersBean> future = restService.getGroupRestService().getUsersFromGroup("jira-software-users", true, 0, 50);
        GroupUsersBean groupUsersBean = future.get();
        Assert.assertNotNull(groupUsersBean);
        List<UserBean> users = groupUsersBean.getUsers();
        Assert.assertFalse(users.isEmpty());
    }
}
