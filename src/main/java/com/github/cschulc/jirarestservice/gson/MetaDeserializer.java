package com.github.cschulc.jirarestservice.gson;

import com.github.cschulc.jirarestservice.domain.ProjectBean;
import com.github.cschulc.jirarestservice.domain.VersionBean;
import com.github.cschulc.jirarestservice.domain.customFields.CustomFieldType;
import com.github.cschulc.jirarestservice.domain.meta.FieldsMetaBean;
import com.github.cschulc.jirarestservice.domain.meta.IssueTypeMetaBean;
import com.github.cschulc.jirarestservice.domain.meta.MetaBean;
import com.github.cschulc.jirarestservice.domain.meta.ProjectMetaBean;
import com.github.cschulc.jirarestservice.domain.meta.custom.ProjectCustomFieldMetaBean;
import com.github.cschulc.jirarestservice.domain.meta.custom.ValueMetaBean;
import com.github.cschulc.jirarestservice.domain.meta.custom.ValuesCustomFieldMetaBean;
import com.github.cschulc.jirarestservice.domain.meta.custom.VersionCustomFieldMetaBean;
import com.github.cschulc.jirarestservice.domain.meta.fields.FieldMetaBean;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class MetaDeserializer extends BaseDeserializer implements JsonDeserializer<MetaBean>{

    public static final String ALLOWED_VALUES = "allowedValues";
    private final Map<String, FieldMetaBean> customFieldsMetaCache = new HashMap<>();

    @Override
    public MetaBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        MetaBean meta = gson.fromJson(json, MetaBean.class);

        Map<String, ProjectMetaBean> projectsMetaMap = new HashMap<>();
        List<ProjectMetaBean> projects = meta.getProjects();
        for (ProjectMetaBean project : projects) {
            projectsMetaMap.put(project.getKey(), project);
        }
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement projectsElement = jsonObject.get("projects");
        JsonArray projectsArray = projectsElement.getAsJsonArray();
        for (JsonElement jsonElement : projectsArray) {
            JsonObject projectObject = jsonElement.getAsJsonObject();
            JsonElement keyElement = projectObject.get("key");
            String key = keyElement.getAsString();
            if (projectsMetaMap.containsKey(key)) {
                ProjectMetaBean projectMeta = projectsMetaMap.get(key);
                processProjectMeta(projectMeta, projectObject);
            }
        }
        return meta;
    }

    private void processProjectMeta(ProjectMetaBean projectMeta, JsonObject projectObject) {
        List<IssueTypeMetaBean> issuetypes = projectMeta.getIssuetypes();
        Map<String, IssueTypeMetaBean> issueTypeMetaMap = new HashMap<>();
        for (IssueTypeMetaBean issuetype : issuetypes) {
            String name = issuetype.getName();
            issueTypeMetaMap.put(name, issuetype);
        }

        JsonElement issuetypesElement = projectObject.get("issuetypes");
        JsonArray issuetypesArray = issuetypesElement.getAsJsonArray();
        for (JsonElement jsonElement : issuetypesArray) {
            JsonObject issuetypeObject = jsonElement.getAsJsonObject();
            JsonElement nameElement = issuetypeObject.get("name");
            String name = nameElement.getAsString();
            if (issueTypeMetaMap.containsKey(name)) {
                IssueTypeMetaBean issueTypeMeta = issueTypeMetaMap.get(name);
                processIssueType(issueTypeMeta, issuetypeObject);
            }
        }
    }


    private void processIssueType(IssueTypeMetaBean issueTypeMeta, JsonObject issuetypeObject) {
        FieldsMetaBean fields = issueTypeMeta.getFields();
        JsonElement fieldsElement = issuetypeObject.get("fields");
        JsonObject fieldsObject = fieldsElement.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = fieldsObject.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String customFieldId = entry.getKey();
            if (customFieldId.startsWith("customfield_")) {
                if(customFieldsMetaCache.containsKey(customFieldId)) {
                    FieldMetaBean fieldMeta = customFieldsMetaCache.get(customFieldId);
                    fields.getCustom().add(fieldMeta);
                }else{
                    FieldMetaBean fieldMeta = extractCustomFieldMeta(customFieldId, entry.getValue());
                    customFieldsMetaCache.put(customFieldId, fieldMeta);
                    fields.getCustom().add(fieldMeta);
                }
            }
        }

    }

    private FieldMetaBean extractCustomFieldMeta(String key, JsonElement json) {
        FieldMetaBean fieldMeta = gson.fromJson(json, FieldMetaBean.class);
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
                ProjectCustomFieldMetaBean projectCustomFieldMeta = new ProjectCustomFieldMetaBean(fieldMeta);
                JsonObject projectCustomFieldObject = json.getAsJsonObject();
                JsonElement projectCustomAllowedValues = projectCustomFieldObject.get(ALLOWED_VALUES);
                JsonArray projectCustomAllowedValuesArray = projectCustomAllowedValues.getAsJsonArray();
                Type projectType = new TypeToken<ArrayList<ProjectBean>>() {
                }.getType();
                List<ProjectBean> projects = gson.fromJson(projectCustomAllowedValuesArray, projectType);
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

    private FieldMetaBean getValueCustomFieldMeta(JsonElement json, FieldMetaBean fieldMeta) {
        ValuesCustomFieldMetaBean valuesCustomFieldMeta = new ValuesCustomFieldMetaBean(fieldMeta);
        JsonObject valuesFieldObject = json.getAsJsonObject();
        JsonElement valuesCustomFieldAllowedValues = valuesFieldObject.get(ALLOWED_VALUES);
        JsonArray valuesCustomFieldAllowedValuesArray = valuesCustomFieldAllowedValues.getAsJsonArray();
        Type valueType = new TypeToken<ArrayList<ValueMetaBean>>(){}.getType();
        List<ValueMetaBean> mutliSelectValues = gson.fromJson(valuesCustomFieldAllowedValuesArray, valueType);
        valuesCustomFieldMeta.setAllowedValues(mutliSelectValues);
        return valuesCustomFieldMeta;
    }

    private FieldMetaBean getVersionCustomFieldMeta(JsonElement json, FieldMetaBean fieldMeta) {
        VersionCustomFieldMetaBean versionCustomFieldMeta = new VersionCustomFieldMetaBean(fieldMeta);
        JsonObject versionCustomFieldObject = json.getAsJsonObject();
        JsonElement versionCustomFieldAllowedValues = versionCustomFieldObject.get(ALLOWED_VALUES);
        JsonArray versionCustomFieldAllowedValuesArray = versionCustomFieldAllowedValues.getAsJsonArray();
        Type versionType = new TypeToken<ArrayList<VersionBean>>(){}.getType();
        List<VersionBean> versions = gson.fromJson(versionCustomFieldAllowedValuesArray, versionType);
        versionCustomFieldMeta.setAllowedValues(versions);
        return versionCustomFieldMeta;
    }
}
