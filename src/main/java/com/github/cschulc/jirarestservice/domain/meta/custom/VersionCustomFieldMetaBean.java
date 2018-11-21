package com.github.cschulc.jirarestservice.domain.meta.custom;

import com.github.cschulc.jirarestservice.domain.VersionBean;
import com.github.cschulc.jirarestservice.domain.meta.fields.FieldMetaBean;

import java.util.ArrayList;
import java.util.List;

public class VersionCustomFieldMetaBean extends FieldMetaBean {

    private List<VersionBean> allowedValues = new ArrayList<>();

    public VersionCustomFieldMetaBean(FieldMetaBean fieldMeta) {
        super(fieldMeta);
    }

    public List<VersionBean> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<VersionBean> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
