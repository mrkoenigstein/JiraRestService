package com.github.cschulc.jirarestservice.domain.meta.fields;

import com.github.cschulc.jirarestservice.domain.Component;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ComponentFieldMeta extends FieldMeta {

    @Expose
    private List<Component> allowedValues = new ArrayList<>();

    public List<Component> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<Component> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
