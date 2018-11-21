package com.github.cschulc.jirarestservice.domain.customFields;


import com.github.cschulc.jirarestservice.domain.BaseBean;

public class CustomFieldBaseBean extends BaseBean {

    private CustomFieldType type;

    public CustomFieldType getType() {
        return type;
    }

    public void setType(CustomFieldType type) {
        this.type = type;
    }
}
