package com.github.cschulc.jirarestservice.domain.meta.fields;

import com.github.cschulc.jirarestservice.domain.meta.SchemaMetaBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

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
}
