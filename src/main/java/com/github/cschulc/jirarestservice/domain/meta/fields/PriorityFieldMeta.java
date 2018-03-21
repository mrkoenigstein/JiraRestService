package com.github.cschulc.jirarestservice.domain.meta.fields;

import com.github.cschulc.jirarestservice.domain.Priority;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class PriorityFieldMeta extends FieldMeta {

    @Expose
    private List<Priority> allowedValues = new ArrayList<>();

    public List<Priority> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<Priority> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
