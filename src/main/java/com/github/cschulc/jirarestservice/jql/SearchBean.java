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

package com.github.cschulc.jirarestservice.jql;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchBean {

    /**
     * Result list start at.
     */
    @Expose
    private Integer startAt = null;

    /**
     * Maximum result list size.
     */
    @Expose
    private Integer maxResults = null;

    /**
     * Result fields for a query.
     */
    @Expose
    private List<String> fields = null;

    @Expose
    private String jql = StringUtils.EMPTY;

    @Expose
    private List<String> expand = new ArrayList<>();

    /**
     * Adds fields which should be returned after the request.
     *
     * @param fields = returned fields
     */
    public void addField(FieldEnum... fields) {
        for (FieldEnum f : fields) {
            getFields().add(f.toString());
        }
    }

    public void addField(Collection<String> fields){
        for (String field : fields) {
            getFields().add(field);
        }
    }

    public void addExpand(FieldEnum... fields){
        for (FieldEnum field : fields) {
            getExpand().add(field.toString());
        }
    }

    /**
     * Gets the start at.
     *
     * @return the start at
     */
    public Integer getStartAt() {
        return startAt;
    }

    /**
     * Sets the start at.
     *
     * @param startAt the new start at
     */
    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    /**
     * Gets the max result.
     *
     * @return the max result
     */
    public Integer getMaxResults() {
        return maxResults;
    }

    /**
     * Sets the max result.
     *
     * @param maxResults the new max result
     */
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * Gets the fields.
     *
     * @return the fields
     */
    public List<String> getFields() {
        if (fields == null) {
            fields = new ArrayList<>();
        }
        return fields;
    }

    public String getJql() {
        return jql;
    }

    public void setJql(String jql) {
        this.jql = jql;
    }

    public List<String> getExpand() {
        if(expand == null){
            expand = new ArrayList<>();
        }
        return expand;
    }
}
