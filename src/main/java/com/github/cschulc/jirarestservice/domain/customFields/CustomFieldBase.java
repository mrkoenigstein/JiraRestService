package com.github.cschulc.jirarestservice.domain.customFields;


import com.github.cschulc.jirarestservice.domain.Base;

public class CustomFieldBase extends Base {

    private CustomFieldType type;

    public CustomFieldType getType() {
        return type;
    }

    public void setType(CustomFieldType type) {
        this.type = type;
    }
}
