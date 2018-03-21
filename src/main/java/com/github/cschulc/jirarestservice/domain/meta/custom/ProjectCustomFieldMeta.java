package com.github.cschulc.jirarestservice.domain.meta.custom;

import com.github.cschulc.jirarestservice.domain.Project;
import com.github.cschulc.jirarestservice.domain.meta.fields.FieldMeta;

import java.util.ArrayList;
import java.util.List;

public class ProjectCustomFieldMeta extends FieldMeta {

    private List<Project> allowedValues = new ArrayList<>();

    public ProjectCustomFieldMeta(FieldMeta fieldMeta) {
        super(fieldMeta);
    }

    public List<Project> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<Project> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
