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

package com.github.cschulc.jirarestservice.domain.meta;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjectMetaBean extends BaseBean {

    @Expose
    private String key;

    @Expose
    private List<IssueTypeMetaBean> issuetypes = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<IssueTypeMetaBean> getIssuetypes() {
        return issuetypes;
    }

    public void setIssuetypes(List<IssueTypeMetaBean> issuetypes) {
        this.issuetypes = issuetypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectMetaBean)) return false;
        if (!super.equals(o)) return false;
        ProjectMetaBean that = (ProjectMetaBean) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(issuetypes, that.issuetypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, issuetypes);
    }
}
