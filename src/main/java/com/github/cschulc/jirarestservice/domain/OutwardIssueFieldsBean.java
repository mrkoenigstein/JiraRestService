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

package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class OutwardIssueFieldsBean {

    @Expose
    private String summary;
    @Expose
    private StatusBean status;
    @Expose
    private PriorityBean priority;
    @Expose
    private IssuetypeBean issuetype;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public PriorityBean getPriority() {
        return priority;
    }

    public void setPriority(PriorityBean priority) {
        this.priority = priority;
    }

    public IssuetypeBean getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssuetypeBean issuetype) {
        this.issuetype = issuetype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutwardIssueFieldsBean)) return false;
        OutwardIssueFieldsBean that = (OutwardIssueFieldsBean) o;
        return Objects.equals(summary, that.summary) &&
                Objects.equals(status, that.status) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(issuetype, that.issuetype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary, status, priority, issuetype);
    }
}
