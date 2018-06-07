package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.permission.PermissionSchemes;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class PermissionSchemeServiceTest extends BaseTest {

    @Test
    public void getPermissionSchemes() throws ExecutionException, InterruptedException {
        Future<PermissionSchemes> future = restService.getPermissionSchemeService().getPermissionsSchemes();
        PermissionSchemes permissionSchemes = future.get();
        Assert.assertNotNull(permissionSchemes);
    }
}
