package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.groups.Groups;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 26.06.2018
 * Time: 09:47
 */
public class GroupServiceTest extends BaseTest {

    @Test
    public void testGetGroups() throws ExecutionException, InterruptedException {
        Future<Groups> future = restService.getGroupService().getGroups(null, null, 0, null);
        Groups groups = future.get();
        Assert.assertNotNull(groups);
    }
}
