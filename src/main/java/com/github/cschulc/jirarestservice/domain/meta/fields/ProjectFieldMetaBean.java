package com.github.cschulc.jirarestservice.domain.meta.fields;

import com.github.cschulc.jirarestservice.domain.ProjectBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ProjectFieldMetaBean extends FieldMetaBean {

    @Expose
    private List<ProjectBean> allowedValues = new ArrayList<>();

    public List<ProjectBean> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<ProjectBean> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
