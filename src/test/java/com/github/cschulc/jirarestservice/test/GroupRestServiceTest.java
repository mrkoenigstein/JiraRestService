package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.groups.GroupUsersBean;
import com.github.cschulc.jirarestservice.domain.groups.GroupsBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import org.testng.Assert;
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
    public void testGetUserFromGroup() throws ExecutionException, InterruptedException {
        Future<GroupUsersBean> future = restService.getGroupRestService().getUsersFromGroup("jira-software-users", true, 0, 50);
        GroupUsersBean groupUsersBean = future.get();
        Assert.assertNotNull(groupUsersBean);
        List<UserBean> users = groupUsersBean.getUsers();
        Assert.assertFalse(users.isEmpty());
    }
}
