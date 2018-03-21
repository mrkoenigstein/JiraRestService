package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.JqlSearchResult;
import com.github.cschulc.jirarestservice.domain.filter.Filter;
import com.github.cschulc.jirarestservice.jql.SearchBean;

import java.util.List;
import java.util.concurrent.Future;

public interface SearchService {

    /**
     * Performs an extended search for issues given by the project.
     *
     * @return list of issues
     */
    Future<JqlSearchResult> searchIssues(SearchBean jsb);

    /**
     * Create a new Search Filter for the logged in User
     *
     * @param filter
     * @return
     */
    Future<Filter> createSearchFilter(Filter filter);


    /**
     * Get favorite Filter for JqlSearch for the logged in User
     *
     * @return List of Filters
     */
    Future<List<Filter>> getFavoriteFilter();

    /**
     * Get Filter by Id
     *
     * @param id the id of the filter
     * @return Filter
     */
    Future<Filter> getFilterById(String id);
}
