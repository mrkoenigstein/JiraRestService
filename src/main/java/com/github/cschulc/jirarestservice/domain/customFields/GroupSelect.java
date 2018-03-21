package com.github.cschulc.jirarestservice.domain.customFields;

import java.util.ArrayList;
import java.util.List;

public class GroupSelect extends CustomFieldBase {

    private List<Value> groups;

    public List<Value> getGroups() {
        if(groups == null){
            groups = new ArrayList<>();
        }
        return groups;
    }

    public void setGroups(List<Value> groups) {
        this.groups = groups;
    }
}
