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

package com.github.cschulc.jirarestservice.domain.security;

import com.github.cschulc.jirarestservice.domain.BaseJsonBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 08:56
 */
public class IssueSecuritySchemesBean extends BaseJsonBean {

    @Expose
    private List<IssueSecuritySchemeBean> issueSecuritySchemes = new ArrayList<>();

    public List<IssueSecuritySchemeBean> getIssueSecuritySchemes() {
        return issueSecuritySchemes;
    }

    public void setIssueSecuritySchemes(List<IssueSecuritySchemeBean> issueSecuritySchemes) {
        this.issueSecuritySchemes = issueSecuritySchemes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IssueSecuritySchemesBean)) return false;
        IssueSecuritySchemesBean that = (IssueSecuritySchemesBean) o;
        return Objects.equals(issueSecuritySchemes, that.issueSecuritySchemes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueSecuritySchemes);
    }
}
