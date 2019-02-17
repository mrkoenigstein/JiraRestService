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

import com.github.cschulc.jirarestservice.domain.permission.PermissionSchemeBean;
import com.github.cschulc.jirarestservice.domain.permission.PermissionSchemesBean;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class PermissionSchemeRestServiceTest extends BaseTest {

    @Test
    public void getPermissionSchemes() throws ExecutionException, InterruptedException {
        Future<PermissionSchemesBean> future = restService.getPermissionSchemeRestService().getPermissionsSchemes();
        PermissionSchemesBean permissionSchemes = future.get();
        Assert.assertNotNull(permissionSchemes);
    }

    @Test
    public void getPermissionScheme() throws ExecutionException, InterruptedException {
        Future<PermissionSchemeBean> future = restService.getPermissionSchemeRestService().getPermissionScheme("0");
        PermissionSchemeBean permissionScheme = future.get();
        Assert.assertNotNull(permissionScheme);
    }
}
