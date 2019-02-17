
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

package com.github.cschulc.jirarestservice.domain.field;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FieldBean extends BaseBean {

    @Expose
    private Boolean custom;
    @Expose
    private Boolean orderable;
    @Expose
    private Boolean navigable;
    @Expose
    private Boolean searchable;
    @Expose
    private List<String> clauseNames = new ArrayList<>();
    @Expose
    private SchemaBean schema;

    public List<String> getClauseNames() {
        return clauseNames;
    }

    public void setClauseNames(List<String> clauseNames) {
        this.clauseNames = clauseNames;
    }

    public Boolean getCustom() {
        return custom;
    }

    public void setCustom(Boolean custom) {
        this.custom = custom;
    }

    public Boolean getNavigable() {
        return navigable;
    }

    public void setNavigable(Boolean navigable) {
        this.navigable = navigable;
    }

    public Boolean getOrderable() {
        return orderable;
    }

    public void setOrderable(Boolean orderable) {
        this.orderable = orderable;
    }

    public SchemaBean getSchema() {
        return schema;
    }

    public void setSchema(SchemaBean schema) {
        this.schema = schema;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldBean)) return false;
        if (!super.equals(o)) return false;
        FieldBean fieldBean = (FieldBean) o;
        return Objects.equals(custom, fieldBean.custom) &&
                Objects.equals(orderable, fieldBean.orderable) &&
                Objects.equals(navigable, fieldBean.navigable) &&
                Objects.equals(searchable, fieldBean.searchable) &&
                Objects.equals(clauseNames, fieldBean.clauseNames) &&
                Objects.equals(schema, fieldBean.schema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), custom, orderable, navigable, searchable, clauseNames, schema);
    }
}
