package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemeBean;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemesBean;
import org.testng.Assert;
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
        Assert.assertFalse(issueSecuritySchemes.getIssueSecuritySchemes().isEmpty());
    }

    @Test
    public void testGetIssueSecurityScheme() throws ExecutionException, InterruptedException {
        Future<IssueSecuritySchemeBean> future = restService.getIssueSecuritySchemeRestService().getIssueSecurityScheme("10000");
        IssueSecuritySchemeBean issueSecurityScheme = future.get();
        Assert.assertNotNull(issueSecurityScheme);
        Assert.assertFalse(issueSecurityScheme.getLevels().isEmpty());
    }
}
