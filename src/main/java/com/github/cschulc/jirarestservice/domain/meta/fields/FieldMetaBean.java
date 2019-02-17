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

package com.github.cschulc.jirarestservice.domain.meta.fields;

import com.github.cschulc.jirarestservice.domain.meta.SchemaMetaBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FieldMetaBean {

    @Expose
    private Boolean required;
    @Expose
    private SchemaMetaBean schema;
    @Expose
    private String name;
    @Expose
    private Boolean hasDefaultValue;
    @Expose
    private List<String> operations = new ArrayList<>();

    public FieldMetaBean() {
    }

    public FieldMetaBean(FieldMetaBean fieldMeta) {
        this.schema = fieldMeta.getSchema();
        this.setName(fieldMeta.getName());
        this.setHasDefaultValue(fieldMeta.getHasDefaultValue());
        this.setOperations(fieldMeta.getOperations());
        this.setRequired(fieldMeta.getRequired());
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public SchemaMetaBean getSchema() {
        return schema;
    }

    public void setSchema(SchemaMetaBean schema) {
        this.schema = schema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasDefaultValue() {
        return hasDefaultValue;
    }

    public void setHasDefaultValue(Boolean hasDefaultValue) {
        this.hasDefaultValue = hasDefaultValue;
    }

    public List<String> getOperations() {
        return operations;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldMetaBean)) return false;
        FieldMetaBean that = (FieldMetaBean) o;
        return Objects.equals(required, that.required) &&
                Objects.equals(schema, that.schema) &&
                Objects.equals(name, that.name) &&
                Objects.equals(hasDefaultValue, that.hasDefaultValue) &&
                Objects.equals(operations, that.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(required, schema, name, hasDefaultValue, operations);
    }
}
