package com.github.cschulc.jirarestservice.domain.meta.custom;

import com.github.cschulc.jirarestservice.domain.meta.fields.FieldMetaBean;

import java.util.ArrayList;
import java.util.List;

public class ValuesCustomFieldMetaBean extends FieldMetaBean {

    private List<ValueMetaBean> allowedValues = new ArrayList<>();

    public ValuesCustomFieldMetaBean(FieldMetaBean fieldMeta) {
        super(fieldMeta);
    }

    public List<ValueMetaBean> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<ValueMetaBean> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
