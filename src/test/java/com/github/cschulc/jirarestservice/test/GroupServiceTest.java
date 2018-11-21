package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.groups.GroupsBean;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 26.06.2018
 * Time: 09:47
 */
public class GroupServiceTest extends BaseTest {

    @Test
    public void testGetGroups() throws ExecutionException, InterruptedException {
        Future<GroupsBean> future = restService.getGroupService().findGroups(null, null, 0, null);
        GroupsBean groups = future.get();
        Assert.assertNotNull(groups);
    }
}
