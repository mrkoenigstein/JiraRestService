package com.github.cschulc.jirarestservice.gson;

import com.github.cschulc.jirarestservice.domain.project.CreateProjectBean;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 04.07.2018
 * Time: 15:51
 */
public class CreateProjectSerializer implements JsonSerializer<CreateProjectBean> {

    @Override
    public JsonElement serialize(CreateProjectBean createProject, Type type, JsonSerializationContext jsonSerializationContext) {
        final JsonObject retval = new JsonObject();
        retval.addProperty("assigneeType", createProject.getAssigneeType());
        if(createProject.getAvatarId() > 0){
            retval.addProperty("avatarId", createProject.getAvatarId());
        }
        if(createProject.getCategoryId() > 0){
            retval.addProperty("categoryId", createProject.getCategoryId());
        }
        if(createProject.getIssueSecurityScheme() > 0){
            retval.addProperty("issueSecurityScheme", createProject.getIssueSecurityScheme());
        }
        if(createProject.getNotificationScheme() > 0){
            retval.addProperty("notificationScheme", createProject.getNotificationScheme());
        }
        if(createProject.getPermissionScheme() > 0){
            retval.addProperty("permissionScheme", createProject.getPermissionScheme());
        }
        retval.addProperty("description", createProject.getDescription());
        retval.addProperty("key", createProject.getKey());
        retval.addProperty("lead", createProject.getLead());
        retval.addProperty("name", createProject.getName());
        retval.addProperty("projectTemplateKey", createProject.getProjectTemplateKey());
        retval.addProperty("projectTypeKey", createProject.getProjectTypeKey());
        retval.addProperty("url", createProject.getUrl());
        return retval;
    }
}
