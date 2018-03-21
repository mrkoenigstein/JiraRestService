package com.github.cschulc.jirarestservice.domain.meta.fields;

import com.github.cschulc.jirarestservice.domain.Version;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 16.03.16.
 */
public class VersionsFieldMeta extends FieldMeta {

    @Expose
    private List<Version> allowedValues = new ArrayList<>();

    public List<Version> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<Version> allowedValues) {
        this.allowedValues = allowedValues;
    }
}
