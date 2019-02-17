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

import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemeBean;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemesBean;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 09:13
 */
public class IssueSecuritySchemeRestServiceTest extends BaseTest {

    @Test
    public void testGetIssueSecuritySchemes() throws ExecutionException, InterruptedException {
        Future<IssueSecuritySchemesBean> future = restService.getIssueSecuritySchemeRestService().getIssueSecuritySchemes();
        IssueSecuritySchemesBean issueSecuritySchemes = future.get();
        Assert.assertNotNull(issueSecuritySchemes);
        Assert.assertTrue(issueSecuritySchemes.getIssueSecuritySchemes().isEmpty());
    }

    @Test
    @Ignore
    public void testGetIssueSecurityScheme() throws ExecutionException, InterruptedException {
        Future<IssueSecuritySchemeBean> future = restService.getIssueSecuritySchemeRestService().getIssueSecurityScheme("10000");
        IssueSecuritySchemeBean issueSecurityScheme = future.get();
        Assert.assertNotNull(issueSecurityScheme);
        Assert.assertFalse(issueSecurityScheme.getLevels().isEmpty());
    }
}
