package com.github.cschulc.jirarestservice.gson;

import com.github.cschulc.jirarestservice.domain.*;
import com.github.cschulc.jirarestservice.domain.customFields.*;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by cschulc on 18.02.16.
 */
public class IssueDeserializer extends BaseDeserializer  implements JsonDeserializer<IssueBean> {

    @Override
    public IssueBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        IssueBean issue = gson.fromJson(json, IssueBean.class);
        FieldsBean fields = issue.getFields();
        if(fields == null){
            return issue;
        }
        List<CustomFieldBaseBean> customField = extractCustomFields(json);
        fields.setCustomFields(customField);
        return issue;
    }


    private List<CustomFieldBaseBean> extractCustomFields(JsonElement json) {
        List<CustomFieldBaseBean> retval = new ArrayList<>();
        JsonObject issueObj = json.getAsJsonObject();
        JsonElement fields = issueObj.get("fields");
        if(fields == null){
            return retval;
        }
        JsonObject fieldsObj = fields.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = fieldsObj.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String key = entry.getKey();
            if (key.startsWith("customfield_")) {
                JsonElement value = entry.getValue();
                if (value.isJsonPrimitive()) {
                    CustomFieldBaseBean customField = getPrimitiveCustomField(key, value);
                    if(customField != null) {
                        customField.setId(key);
                        retval.add(customField);
                    }
                }
                else if (value.isJsonObject()) {
                    CustomFieldBaseBean customField = getObjectCustomField(key, value);
                    if(customField != null){
                        customField.setId(key);
                        retval.add(customField);
                    }
                }
                else if (value.isJsonArray()) {
                    CustomFieldBaseBean arrayCustomField = getArrayCustomField(key, value);
                    if(arrayCustomField != null){
                        arrayCustomField.setId(key);
                        retval.add(arrayCustomField);
                    }
                }
            }
        }
        return retval;
    }




    private CustomFieldBaseBean getPrimitiveCustomField(String key, JsonElement jsonElement) {
        SingleValueBean retval = new SingleValueBean();
        String string = jsonElement.getAsString();
        ValueBean value = new ValueBean();
        value.setValue(string);
        retval.setValue(value);
        CustomFieldType customFieldType = getCustomFieldType(key);
        if(customFieldType == null){
            return null;
        }
        retval.setType(customFieldType);
        return retval;
    }

    private CustomFieldBaseBean getObjectCustomField(String id, JsonElement jsonElement) {
        CustomFieldType customFieldType = getCustomFieldType(id);
        if(customFieldType == null){
            return null;
        }
        switch (customFieldType){
            case SELECT:
                ValueBean value = gson.fromJson(jsonElement, ValueBean.class);
                SingleValueBean singleValue = new SingleValueBean();
                singleValue.setType(CustomFieldType.SELECT);
                singleValue.setValue(value);
                return singleValue;
            case RADIO:
                ValueBean optionValue = gson.fromJson(jsonElement, ValueBean.class);
                SingleValueBean option = new SingleValueBean();
                option.setType(CustomFieldType.RADIO);
                option.setValue(optionValue);
                return option;
            case USER:
                UserBean user = gson.fromJson(jsonElement, UserBean.class);
                UserSelectBean userSelect = new UserSelectBean();
                userSelect.setType(CustomFieldType.USER);
                userSelect.getUsers().add(user);
                return userSelect;
            case PROJECT:
                ProjectBean project = gson.fromJson(jsonElement, ProjectBean.class);
                ProjectSelectBean projectSelect = new ProjectSelectBean();
                projectSelect.setType(CustomFieldType.PROJECT);
                projectSelect.setProject(project);
                return projectSelect;
            case CASCADING:
                ValueBean cValue = gson.fromJson(jsonElement, ValueBean.class);
                CascadingValueBean cascadingValue = new CascadingValueBean();
                cascadingValue.setType(CustomFieldType.CASCADING);
                cascadingValue.setValue(cValue);
                return cascadingValue;
            case GROUP:
                ValueBean groupValue = gson.fromJson(jsonElement, ValueBean.class);
                GroupSelectBean groupSelect = new GroupSelectBean();
                groupSelect.setType(CustomFieldType.GROUP);
                groupSelect.getGroups().add(groupValue);
                return groupSelect;
            case VERSION:
                VersionBean version = gson.fromJson(jsonElement, VersionBean.class);
                VersionSelectBean versionSelect = new VersionSelectBean();
                versionSelect.setType(CustomFieldType.VERSION);
                versionSelect.getVersions().add(version);
                return versionSelect;
            default:
                return null;
        }
    }

    private CustomFieldBaseBean getArrayCustomField(String id, JsonElement json) {
        CustomFieldType customFieldType = getCustomFieldType(id);
        if(customFieldType == null){
            return null;
        }
        Type valueType = new TypeToken<Collection<ValueBean>>(){}.getType();
        switch (customFieldType){
            case LABELS:
                Type type = new TypeToken<Collection<String>>(){}.getType();
                List<String> labelsList = gson.fromJson(json, type);
                MultiValueBean labels = new MultiValueBean();
                labels.setType(CustomFieldType.LABELS);
                for (String label : labelsList) {
                    ValueBean value = new ValueBean();
                    value.setValue(label);
                    labels.getValues().add(value);
                }
                return labels;
            case MULTISELECT:
                List<ValueBean> multiSelectValues = gson.fromJson(json, valueType);
                MultiValueBean multiSelect = new MultiValueBean();
                multiSelect.setType(CustomFieldType.MULTISELECT);
                multiSelect.setValues(multiSelectValues);
                return multiSelect;
            case CHECKBOX:
                List<ValueBean> checkboxValues = gson.fromJson(json, valueType);
                MultiValueBean checkbox = new MultiValueBean();
                checkbox.setType(CustomFieldType.CHECKBOX);
                checkbox.setValues(checkboxValues);
                return checkbox;
            case MULTIUSER:
                Type userType = new TypeToken<Collection<UserBean>>(){}.getType();
                List<UserBean> userSelectValues = gson.fromJson(json, userType);
                UserSelectBean userSelect = new UserSelectBean();
                userSelect.setType(CustomFieldType.MULTIUSER);
                userSelect.setUsers(userSelectValues);
                return userSelect;
            case MULTIVERSION:
                Type versionType = new TypeToken<Collection<VersionBean>>(){}.getType();
                List<VersionBean> versionSelectValues = gson.fromJson(json, versionType);
                VersionSelectBean versionSelect = new VersionSelectBean();
                versionSelect.setType(CustomFieldType.MULTIVERSION);
                versionSelect.setVersions(versionSelectValues);
                return versionSelect;
            case MULTIGROUP:
                List<ValueBean> groupSelectValues = gson.fromJson(json, valueType);
                GroupSelectBean groupSelect = new GroupSelectBean();
                groupSelect.setType(CustomFieldType.MULTIGROUP);
                groupSelect.setGroups(groupSelectValues);
                return groupSelect;
            default:
                return null;
        }
    }





}
