package com.github.cschulc.jirarestservice.domain.meta.custom;

import com.github.cschulc.jirarestservice.domain.Version;
import com.github.cschulc.jirarestservice.domain.meta.fields.FieldMeta;

import java.util.ArrayList;
import java.util.List;

public class VersionCustomFieldMeta extends FieldMeta {

    private List<Version> allowedValues = new ArrayList<>();

    public VersionCustomFieldMeta(FieldMeta fieldMeta) {
        super(fieldMeta);
    }

    public List<Version> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<Version> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
