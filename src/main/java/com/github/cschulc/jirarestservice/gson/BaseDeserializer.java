package com.github.cschulc.jirarestservice.gson;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.customFields.CustomFieldType;
import com.github.cschulc.jirarestservice.domain.field.FieldBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseDeserializer {


    protected final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    protected CustomFieldType getCustomFieldType(String customFieldId) {
        FieldBean fieldBean = JiraRestService.getCustomfields().get(customFieldId);
        if(fieldBean == null){
            return null;
        }
        String custom = fieldBean.getSchema().getCustom();
        if (custom == null) {
            return null;
        }
        CustomFieldType[] values = CustomFieldType.values();
        for (CustomFieldType value : values) {
            if (custom.equals(value.getJiraName()) == true) {
                return value;
            }
        }
        return null;
    }
}
