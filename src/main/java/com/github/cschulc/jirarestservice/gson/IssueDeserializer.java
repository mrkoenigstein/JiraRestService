package com.github.cschulc.jirarestservice.gson;

import com.github.cschulc.jirarestservice.domain.*;
import com.github.cschulc.jirarestservice.domain.customFields.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by cschulc on 18.02.16.
 */
public class IssueDeserializer extends BaseDeserializer  implements JsonDeserializer<Issue> {

    @Override
    public Issue deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Issue issue = gson.fromJson(json, Issue.class);
        Fields fields = issue.getFields();
        if(fields == null){
            return issue;
        }
        List<CustomFieldBase> customField = extractCustomFields(json);
        fields.setCustomFields(customField);
        return issue;
    }


    private List<CustomFieldBase> extractCustomFields(JsonElement json) {
        List<CustomFieldBase> retval = new ArrayList<>();
        JsonObject issueObj = json.getAsJsonObject();
        JsonElement fields = issueObj.get("fields");
        if(fields == null){
            return retval;
        }
        JsonObject fieldsObj = fields.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = fieldsObj.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String key = entry.getKey();
            if (key.startsWith("customfield_") == true) {
                JsonElement value = entry.getValue();
                if (value.isJsonPrimitive() == true) {
                    CustomFieldBase customField = getPrimitiveCustomField(key, value);
                    if(customField != null) {
                        customField.setId(key);
                        retval.add(customField);
                    }
                }
                else if (value.isJsonObject() == true) {
                    CustomFieldBase customField = getObjectCustomField(key, value);
                    if(customField != null){
                        customField.setId(key);
                        retval.add(customField);
                    }
                }
                else if (value.isJsonArray() == true) {
                    CustomFieldBase arrayCustomField = getArrayCustomField(key, value);
                    if(arrayCustomField != null){
                        arrayCustomField.setId(key);
                        retval.add(arrayCustomField);
                    }
                }
                else if (value.isJsonNull() == true) {

                }
            }
        }
        return retval;
    }




    private CustomFieldBase getPrimitiveCustomField(String key, JsonElement jsonElement) {
        SingleValue retval = new SingleValue();
        String string = jsonElement.getAsString();
        Value value = new Value();
        value.setValue(string);
        retval.setValue(value);
        CustomFieldType customFieldType = getCustomFieldType(key);
        if(customFieldType == null){
            return null;
        }
        retval.setType(customFieldType);
        return retval;
    }

    private CustomFieldBase getObjectCustomField(String id, JsonElement jsonElement) {
        CustomFieldType customFieldType = getCustomFieldType(id);
        if(customFieldType == null){
            return null;
        }
        switch (customFieldType){
            case SELECT:
                Value value = gson.fromJson(jsonElement, Value.class);
                SingleValue singleValue = new SingleValue();
                singleValue.setType(CustomFieldType.SELECT);
                singleValue.setValue(value);
                return singleValue;
            case RADIO:
                Value optionValue = gson.fromJson(jsonElement, Value.class);
                SingleValue option = new SingleValue();
                option.setType(CustomFieldType.RADIO);
                option.setValue(optionValue);
                return option;
            case USER:
                User user = gson.fromJson(jsonElement, User.class);
                UserSelect userSelect = new UserSelect();
                userSelect.setType(CustomFieldType.USER);
                userSelect.getUsers().add(user);
                return userSelect;
            case PROJECT:
                Project project = gson.fromJson(jsonElement, Project.class);
                ProjectSelect projectSelect = new ProjectSelect();
                projectSelect.setType(CustomFieldType.PROJECT);
                projectSelect.setProject(project);
                return projectSelect;
            case CASCADING:
                Value cValue = gson.fromJson(jsonElement, Value.class);
                CascadingValue cascadingValue = new CascadingValue();
                cascadingValue.setType(CustomFieldType.CASCADING);
                cascadingValue.setValue(cValue);
                return cascadingValue;
            case GROUP:
                Value groupValue = gson.fromJson(jsonElement, Value.class);
                GroupSelect groupSelect = new GroupSelect();
                groupSelect.setType(CustomFieldType.GROUP);
                groupSelect.getGroups().add(groupValue);
                return groupSelect;
            case VERSION:
                Version version = gson.fromJson(jsonElement, Version.class);
                VersionSelect versionSelect = new VersionSelect();
                versionSelect.setType(CustomFieldType.VERSION);
                versionSelect.getVersions().add(version);
                return versionSelect;
            default:
                return null;
        }
    }

    private CustomFieldBase getArrayCustomField(String id, JsonElement json) {
        CustomFieldType customFieldType = getCustomFieldType(id);
        if(customFieldType == null){
            return null;
        }
        Type valueType = new TypeToken<Collection<Value>>(){}.getType();
        switch (customFieldType){
            case LABELS:
                Type type = new TypeToken<Collection<String>>(){}.getType();
                List<String> labelsList = gson.fromJson(json, type);
                MultiValue labels = new MultiValue();
                labels.setType(CustomFieldType.LABELS);
                for (String label : labelsList) {
                    Value value = new Value();
                    value.setValue(label);
                    labels.getValues().add(value);
                }
                return labels;
            case MULTISELECT:
                List<Value> multiSelectValues = gson.fromJson(json, valueType);
                MultiValue multiSelect = new MultiValue();
                multiSelect.setType(CustomFieldType.MULTISELECT);
                multiSelect.setValues(multiSelectValues);
                return multiSelect;
            case CHECKBOX:
                List<Value> checkboxValues = gson.fromJson(json, valueType);
                MultiValue checkbox = new MultiValue();
                checkbox.setType(CustomFieldType.CHECKBOX);
                checkbox.setValues(checkboxValues);
                return checkbox;
            case MULTIUSER:
                Type userType = new TypeToken<Collection<User>>(){}.getType();
                List<User> userSelectValues = gson.fromJson(json, userType);
                UserSelect userSelect = new UserSelect();
                userSelect.setType(CustomFieldType.MULTIUSER);
                userSelect.setUsers(userSelectValues);
                return userSelect;
            case MULTIVERSION:
                Type versionType = new TypeToken<Collection<Version>>(){}.getType();
                List<Version> versionSelectValues = gson.fromJson(json, versionType);
                VersionSelect versionSelect = new VersionSelect();
                versionSelect.setType(CustomFieldType.MULTIVERSION);
                versionSelect.setVersions(versionSelectValues);
                return versionSelect;
            case MULTIGROUP:
                List<Value> groupSelectValues = gson.fromJson(json, valueType);
                GroupSelect groupSelect = new GroupSelect();
                groupSelect.setType(CustomFieldType.MULTIGROUP);
                groupSelect.setGroups(groupSelectValues);
                return groupSelect;
            default:
                return null;
        }
    }





}
