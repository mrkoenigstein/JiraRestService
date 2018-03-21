package com.github.cschulc.jirarestservice.domain.meta.fields;

import com.github.cschulc.jirarestservice.domain.Project;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ProjectFieldMeta extends FieldMeta {

    @Expose
    private List<Project> allowedValues = new ArrayList<>();

    public List<Project> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<Project> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
