package com.github.cschulc.jirarestservice.domain.customFields;

import com.github.cschulc.jirarestservice.domain.Version;

import java.util.ArrayList;
import java.util.List;

public class VersionSelect extends CustomFieldBase {

    private List<Version> versions;

    public List<Version> getVersions() {
        if(versions == null){
            versions = new ArrayList<>();
        }
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }
}
