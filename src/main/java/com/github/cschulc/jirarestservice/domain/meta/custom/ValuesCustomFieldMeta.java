package com.github.cschulc.jirarestservice.domain.meta.custom;

import com.github.cschulc.jirarestservice.domain.meta.fields.FieldMeta;

import java.util.ArrayList;
import java.util.List;

public class ValuesCustomFieldMeta extends FieldMeta {

    private List<ValueMeta> allowedValues = new ArrayList<>();

    public ValuesCustomFieldMeta(FieldMeta fieldMeta) {
        super(fieldMeta);
    }

    public List<ValueMeta> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<ValueMeta> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
