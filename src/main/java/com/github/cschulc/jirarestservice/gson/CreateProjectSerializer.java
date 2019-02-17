/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

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
