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

import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemeBean;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemesBean;

import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 08:54
 */
public interface IssueSecuritySchemeRestService {

    /**
     * Returns all issue security schemes that are defined.
     *
     * @return IssueSecuritySchemesBean as root object
     */
    Future<IssueSecuritySchemesBean> getIssueSecuritySchemes();

    /**
     * Returns the issue security scheme along with that are defined.
     *
     * @param id The id of the IssueSecuritySchemeBean
     * @return IssueSecuritySchemeBean
     */
    Future<IssueSecuritySchemeBean> getIssueSecurityScheme(String id);
}
