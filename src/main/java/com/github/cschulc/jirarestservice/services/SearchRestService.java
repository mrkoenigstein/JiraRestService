package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.JqlSearchResultBean;
import com.github.cschulc.jirarestservice.domain.filter.FilterBean;
import com.github.cschulc.jirarestservice.jql.SearchBean;

import java.util.List;
import java.util.concurrent.Future;

public interface SearchRestService {

    /**
     * Performs an extended search for issues given by the project.
     *
     * @return list of issues
     */
    Future<JqlSearchResultBean> searchIssues(SearchBean jsb);

    /**
     * Create a new Search FilterBean for the logged in UserBean
     *
     * @param filter
     * @return
     */
    Future<FilterBean> createSearchFilter(FilterBean filter);


    /**
     * Get favorite FilterBean for JqlSearch for the logged in UserBean
     *
     * @return List of Filters
     */
    Future<List<FilterBean>> getFavoriteFilter();

    /**
     * Get FilterBean by Id
     *
     * @param id the id of the filter
     * @return FilterBean
     */
    Future<FilterBean> getFilterById(String id);
}
