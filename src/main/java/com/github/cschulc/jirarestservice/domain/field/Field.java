
package com.github.cschulc.jirarestservice.domain.field;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Field extends Base {

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
    private Schema schema;

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

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }
}
