package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.security.IssueSecurityScheme;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemes;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 09:13
 */
public class IssueSecuritySchemeServiceTest extends BaseTest {

    @Test
    public void testGetIssueSecuritySchemes() throws ExecutionException, InterruptedException {
        Future<IssueSecuritySchemes> future = restService.getIssueSecuritySchemeService().getIssueSecuritySchemes();
        IssueSecuritySchemes issueSecuritySchemes = future.get();
        Assert.assertNotNull(issueSecuritySchemes);
        Assert.assertFalse(issueSecuritySchemes.getIssueSecuritySchemes().isEmpty());
    }

    @Test
    public void testGetIssueSecurityScheme() throws ExecutionException, InterruptedException {
        Future<IssueSecurityScheme> future = restService.getIssueSecuritySchemeService().getIssueSecurityScheme("10000");
        IssueSecurityScheme issueSecurityScheme = future.get();
        Assert.assertNotNull(issueSecurityScheme);
        Assert.assertFalse(issueSecurityScheme.getLevels().isEmpty());
    }
}
