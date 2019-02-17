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
     * @param filter The filter to create
     * @return The created Filter
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
