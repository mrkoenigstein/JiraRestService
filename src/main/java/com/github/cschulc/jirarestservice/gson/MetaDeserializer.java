package com.github.cschulc.jirarestservice.gson;

import com.github.cschulc.jirarestservice.domain.Project;
import com.github.cschulc.jirarestservice.domain.Version;
import com.github.cschulc.jirarestservice.domain.customFields.CustomFieldType;
import com.github.cschulc.jirarestservice.domain.meta.FieldsMeta;
import com.github.cschulc.jirarestservice.domain.meta.IssueTypeMeta;
import com.github.cschulc.jirarestservice.domain.meta.Meta;
import com.github.cschulc.jirarestservice.domain.meta.ProjectMeta;
import com.github.cschulc.jirarestservice.domain.meta.custom.ProjectCustomFieldMeta;
import com.github.cschulc.jirarestservice.domain.meta.custom.ValueMeta;
import com.github.cschulc.jirarestservice.domain.meta.custom.ValuesCustomFieldMeta;
import com.github.cschulc.jirarestservice.domain.meta.custom.VersionCustomFieldMeta;
import com.github.cschulc.jirarestservice.domain.meta.fields.FieldMeta;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class MetaDeserializer extends BaseDeserializer implements JsonDeserializer<Meta>{

    public static final String ALLOWED_VALUES = "allowedValues";
    private final Map<String, FieldMeta> customFieldsMetaCache = new HashMap<>();

    @Override
    public Meta deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Meta meta = gson.fromJson(json, Meta.class);

        Map<String, ProjectMeta> projectsMetaMap = new HashMap<>();
        List<ProjectMeta> projects = meta.getProjects();
        for (ProjectMeta project : projects) {
            projectsMetaMap.put(project.getKey(), project);
        }
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement projectsElement = jsonObject.get("projects");
        JsonArray projectsArray = projectsElement.getAsJsonArray();
        for (JsonElement jsonElement : projectsArray) {
            JsonObject projectObject = jsonElement.getAsJsonObject();
            JsonElement keyElement = projectObject.get("key");
            String key = keyElement.getAsString();
            if (projectsMetaMap.containsKey(key) == true) {
                ProjectMeta projectMeta = projectsMetaMap.get(key);
                processProjectMeta(projectMeta, projectObject);
            }
        }
        return meta;
    }

    private void processProjectMeta(ProjectMeta projectMeta, JsonObject projectObject) {
        List<IssueTypeMeta> issuetypes = projectMeta.getIssuetypes();
        Map<String, IssueTypeMeta> issueTypeMetaMap = new HashMap<>();
        for (IssueTypeMeta issuetype : issuetypes) {
            String name = issuetype.getName();
            issueTypeMetaMap.put(name, issuetype);
        }

        JsonElement issuetypesElement = projectObject.get("issuetypes");
        JsonArray issuetypesArray = issuetypesElement.getAsJsonArray();
        for (JsonElement jsonElement : issuetypesArray) {
            JsonObject issuetypeObject = jsonElement.getAsJsonObject();
            JsonElement nameElement = issuetypeObject.get("name");
            String name = nameElement.getAsString();
            if (issueTypeMetaMap.containsKey(name) == true) {
                IssueTypeMeta issueTypeMeta = issueTypeMetaMap.get(name);
                processIssueType(issueTypeMeta, issuetypeObject);
            }
        }
    }


    private void processIssueType(IssueTypeMeta issueTypeMeta, JsonObject issuetypeObject) {
        FieldsMeta fields = issueTypeMeta.getFields();
        JsonElement fieldsElement = issuetypeObject.get("fields");
        JsonObject fieldsObject = fieldsElement.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = fieldsObject.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String customFieldId = entry.getKey();
            if (customFieldId.startsWith("customfield_") == true) {
                if(customFieldsMetaCache.containsKey(customFieldId) == true) {
                    FieldMeta fieldMeta = customFieldsMetaCache.get(customFieldId);
                    fields.getCustom().add(fieldMeta);
                }else{
                    FieldMeta fieldMeta = extractCustomFieldMeta(customFieldId, entry.getValue());
                    customFieldsMetaCache.put(customFieldId, fieldMeta);
                    fields.getCustom().add(fieldMeta);
                }
            }
        }

    }

    private FieldMeta extractCustomFieldMeta(String key, JsonElement json) {
        FieldMeta fieldMeta = gson.fromJson(json, FieldMeta.class);
        CustomFieldType customFieldType = getCustomFieldType(key);
        if(customFieldType == null){
            return fieldMeta;
        }
        switch (customFieldType){
            case URL:
                return fieldMeta;
            case DATE:
                return fieldMeta;
            case DATETIME:
                return fieldMeta;
            case TEXT:
                return fieldMeta;
            case TEXTAREA:
                return fieldMeta;
            case FLOAT:
                return fieldMeta;
            case SELECT:
                return getValueCustomFieldMeta(json, fieldMeta);
            case RADIO:
                return getValueCustomFieldMeta(json, fieldMeta);
            case USER:
                return fieldMeta;
            case PROJECT:
                ProjectCustomFieldMeta projectCustomFieldMeta = new ProjectCustomFieldMeta(fieldMeta);
                JsonObject projectCustomFieldObject = json.getAsJsonObject();
                JsonElement projectCustomAllowedValues = projectCustomFieldObject.get(ALLOWED_VALUES);
                JsonArray projectCustomAllowedValuesArray = projectCustomAllowedValues.getAsJsonArray();
                Type projectType = new TypeToken<ArrayList<Project>>() {
                }.getType();
                List<Project> projects = gson.fromJson(projectCustomAllowedValuesArray, projectType);
                projectCustomFieldMeta.setAllowedValues(projects);
                return projectCustomFieldMeta;
            case CASCADING:
                return getValueCustomFieldMeta(json, fieldMeta);
            case GROUP:
                return fieldMeta;
            case VERSION:
                return getVersionCustomFieldMeta(json, fieldMeta);
            case LABELS:
                return fieldMeta;
            case MULTISELECT:
                return getValueCustomFieldMeta(json, fieldMeta);
            case CHECKBOX:
                return getValueCustomFieldMeta(json, fieldMeta);
            case MULTIUSER:
                return fieldMeta;
            case MULTIVERSION:
                return getVersionCustomFieldMeta(json, fieldMeta);
            case MULTIGROUP:
                return fieldMeta;
            default:
                return fieldMeta;
        }
    }

    private FieldMeta getValueCustomFieldMeta(JsonElement json, FieldMeta fieldMeta) {
        ValuesCustomFieldMeta valuesCustomFieldMeta = new ValuesCustomFieldMeta(fieldMeta);
        JsonObject valuesFieldObject = json.getAsJsonObject();
        JsonElement valuesCustomFieldAllowedValues = valuesFieldObject.get(ALLOWED_VALUES);
        JsonArray valuesCustomFieldAllowedValuesArray = valuesCustomFieldAllowedValues.getAsJsonArray();
        Type valueType = new TypeToken<ArrayList<ValueMeta>>(){}.getType();
        List<ValueMeta> mutliSelectValues = gson.fromJson(valuesCustomFieldAllowedValuesArray, valueType);
        valuesCustomFieldMeta.setAllowedValues(mutliSelectValues);
        return valuesCustomFieldMeta;
    }

    private FieldMeta getVersionCustomFieldMeta(JsonElement json, FieldMeta fieldMeta) {
        VersionCustomFieldMeta versionCustomFieldMeta = new VersionCustomFieldMeta(fieldMeta);
        JsonObject versionCustomFieldObject = json.getAsJsonObject();
        JsonElement versionCustomFieldAllowedValues = versionCustomFieldObject.get(ALLOWED_VALUES);
        JsonArray versionCustomFieldAllowedValuesArray = versionCustomFieldAllowedValues.getAsJsonArray();
        Type versionType = new TypeToken<ArrayList<Version>>(){}.getType();
        List<Version> versions = gson.fromJson(versionCustomFieldAllowedValuesArray, versionType);
        versionCustomFieldMeta.setAllowedValues(versions);
        return versionCustomFieldMeta;
    }
}
