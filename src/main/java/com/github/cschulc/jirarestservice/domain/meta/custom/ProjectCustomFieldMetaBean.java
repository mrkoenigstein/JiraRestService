package com.github.cschulc.jirarestservice.domain.meta.custom;

import com.github.cschulc.jirarestservice.domain.ProjectBean;
import com.github.cschulc.jirarestservice.domain.meta.fields.FieldMetaBean;

import java.util.ArrayList;
import java.util.List;

public class ProjectCustomFieldMetaBean extends FieldMetaBean {

    private List<ProjectBean> allowedValues = new ArrayList<>();

    public ProjectCustomFieldMetaBean(FieldMetaBean fieldMeta) {
        super(fieldMeta);
    }

    public List<ProjectBean> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<ProjectBean> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
