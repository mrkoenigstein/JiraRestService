package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.permission.PermissionScheme;
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

    @Test
    public void getPermissionScheme() throws ExecutionException, InterruptedException {
        Future<PermissionScheme> future = restService.getPermissionSchemeService().getPermissionScheme("0");
        PermissionScheme permissionScheme = future.get();
        Assert.assertNotNull(permissionScheme);
    }
}
