package com.github.cschulc.jirarestservice.domain.customFields;

import com.github.cschulc.jirarestservice.domain.VersionBean;

import java.util.ArrayList;
import java.util.List;

public class VersionSelectBean extends CustomFieldBaseBean {

    private List<VersionBean> versions;

    public List<VersionBean> getVersions() {
        if(versions == null){
            versions = new ArrayList<>();
        }
        return versions;
    }

    public void setVersions(List<VersionBean> versions) {
        this.versions = versions;
    }
}
