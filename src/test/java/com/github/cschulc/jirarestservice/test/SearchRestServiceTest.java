package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.JqlSearchResultBean;
import com.github.cschulc.jirarestservice.domain.filter.FilterBean;
import com.github.cschulc.jirarestservice.jql.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.github.cschulc.jirarestservice.jql.Constants.STATUS_IN_PROGRESS;
import static com.github.cschulc.jirarestservice.jql.Constants.STATUS_OPEN;

/**
 * @author Christian Schulze
 */
public class SearchRestServiceTest extends BaseTest{

    @Test
    public void testSearchIssues() throws ExecutionException, InterruptedException {
        SearchBean jsb = new SearchBean();
        JqlBuilder builder = new JqlBuilder();
        String jql = builder.addCondition(FieldEnum.PROJECT, OperatorEnum.EQUALS, "DEMO")
                .and().addCondition(FieldEnum.STATUS, OperatorEnum.EQUALS, STATUS_OPEN)
                .orderBy(SortOrderEnum.ASC, FieldEnum.CREATED);
        jsb.setJql(jql);
        jsb.addField(FieldEnum.ISSUE_KEY, FieldEnum.STATUS, FieldEnum.DUE, FieldEnum.SUMMARY, FieldEnum.ISSUE_TYPE, FieldEnum.PRIORITY, FieldEnum.UPDATED, FieldEnum.TRANSITIONS);
        jsb.addExpand(FieldEnum.TRANSITIONS);
        Future<JqlSearchResultBean> future = restService.getSearchRestService().searchIssues(jsb);
        JqlSearchResultBean jqlSearchResult = future.get();
        Assert.assertNotNull(jqlSearchResult);
        Assert.assertEquals(jqlSearchResult.getIssues().size(), jqlSearchResult.getTotal());
        Assert.assertEquals(jqlSearchResult.getTotal(), 0);
    }

    @Test
    public void testSearchIssueWithMultipleValues() throws  ExecutionException, InterruptedException {
        SearchBean jsb = new SearchBean();
        JqlBuilder builder = new JqlBuilder();
        String jql = builder.addCondition(FieldEnum.PROJECT, OperatorEnum.EQUALS, "DEMO")
                .and().addCondition(FieldEnum.STATUS, OperatorEnum.IN, STATUS_OPEN, STATUS_IN_PROGRESS)
                .orderBy(SortOrderEnum.ASC, FieldEnum.CREATED);
        jsb.setJql(jql);
        jsb.addField(FieldEnum.ISSUE_KEY, FieldEnum.STATUS, FieldEnum.DUE, FieldEnum.SUMMARY, FieldEnum.ISSUE_TYPE, FieldEnum.PRIORITY, FieldEnum.UPDATED, FieldEnum.TRANSITIONS);
        jsb.addExpand(FieldEnum.TRANSITIONS);
        Future<JqlSearchResultBean> future = restService.getSearchRestService().searchIssues(jsb);
        JqlSearchResultBean jqlSearchResult = future.get();
        Assert.assertNotNull(jqlSearchResult);
        Assert.assertEquals(jqlSearchResult.getIssues().size(), jqlSearchResult.getTotal());
        Assert.assertEquals(jqlSearchResult.getTotal(), 0);

    }

    @Test
    public void testCountIssues() throws ExecutionException, InterruptedException {
        SearchBean jsb = new SearchBean();
        JqlBuilder builder = new JqlBuilder();
        String jql = builder.addCondition(FieldEnum.PROJECT, OperatorEnum.EQUALS, "DEMO").build();
        jsb.setJql(jql);
        jsb.addField(FieldEnum.ISSUE_KEY, FieldEnum.STATUS, FieldEnum.DUE, FieldEnum.ISSUE_TYPE);
        Future<JqlSearchResultBean> future = restService.getSearchRestService().searchIssues(jsb);
        JqlSearchResultBean jqlSearchResult = future.get();
        Assert.assertNotNull(jqlSearchResult);
        Assert.assertEquals(jqlSearchResult.getIssues().size(), jqlSearchResult.getTotal());
        Assert.assertTrue(jqlSearchResult.getTotal() > 0);
    }


    @Test
    @Ignore
    public void testCreateFilter() {
        FilterBean filter = new FilterBean();
        filter.setName("Demo ProjectBean");
        filter.setDescription("A FilterBean for the Demo ProjectBean");
        filter.setFavourite(Boolean.TRUE);
        filter.setJql("project = DEMO");
        final Future<FilterBean> future = restService.getSearchRestService().createSearchFilter(filter);
        final FilterBean createdFilter;
        try {
            createdFilter = future.get();
            Assert.assertNotNull(createdFilter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            final Throwable cause = e.getCause();
            cause.printStackTrace();
        }

    }

    @Test
    public void testGetFilterForLoggedInUser() throws ExecutionException, InterruptedException {
        final Future<List<FilterBean>> future = restService.getSearchRestService().getFavoriteFilter();
        final List<FilterBean> filters = future.get();
        Assert.assertNotNull(filters);
        Assert.assertFalse(filters.isEmpty());
    }

    @Test
    public void testGetFilterById() throws ExecutionException, InterruptedException {
        Future<FilterBean> future = restService.getSearchRestService().getFilterById("10000");
        FilterBean filter = future.get();
        Assert.assertNotNull(filter);
    }
}
