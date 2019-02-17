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

import java.util.List;
import java.util.Objects;

public class IssueBean extends BaseBean {

    @Expose
    private FieldsBean fields;
    @Expose
    private String key;
    @Expose
    private RenderedFieldsBean renderedFields;
    @Expose
    private List<TransitionBean> transitions;
    @Expose
    private ChangelogBean changelog;

    public FieldsBean getFields() {
        return fields;
    }

    public void setFields(FieldsBean fields) {
        this.fields = fields;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RenderedFieldsBean getRenderedFields() {
        return renderedFields;
    }

    public void setRenderedFields(RenderedFieldsBean renderedFields) {
        this.renderedFields = renderedFields;
    }

    public List<TransitionBean> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<TransitionBean> transitions) {
        this.transitions = transitions;
    }

    public ChangelogBean getChangelog() {
        return changelog;
    }

    public void setChangelog(ChangelogBean changelog) {
        this.changelog = changelog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IssueBean)) return false;
        if (!super.equals(o)) return false;
        IssueBean issueBean = (IssueBean) o;
        return Objects.equals(fields, issueBean.fields) &&
                Objects.equals(key, issueBean.key) &&
                Objects.equals(renderedFields, issueBean.renderedFields) &&
                Objects.equals(transitions, issueBean.transitions) &&
                Objects.equals(changelog, issueBean.changelog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fields, key, renderedFields, transitions, changelog);
    }
}
