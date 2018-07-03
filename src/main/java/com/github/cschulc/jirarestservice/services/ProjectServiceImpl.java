package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.Component;
import com.github.cschulc.jirarestservice.domain.Project;
import com.github.cschulc.jirarestservice.domain.Version;
import com.github.cschulc.jirarestservice.domain.meta.Meta;
import com.github.cschulc.jirarestservice.domain.project.ProjectCategory;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang3.Validate;
import org.apache.http.client.utils.URIBuilder;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ProjectServiceImpl extends BaseService implements ProjectService {


    public ProjectServiceImpl(JiraRestService restService, ExecutorService executorService) {
        super(restService);
        this.executorService = executorService;
    }

    public Future<Project> getProjectByKey(final String projectKey) {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT, projectKey);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Project project = gson.fromJson(jsonReader, Project.class);
                restApiCall.release();
                return project;
            } else {
                throw restApiCall.buildException();
            }
        });

    }


    public Future<List<Project>> getAllProjects() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<Project>>() {
                }.getType();
                List<Project> projects = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return projects;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<Version>> getProjectVersions(final String projectKey) {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT, projectKey, VERSIONS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<Version>>() {
                }.getType();
                List<Version> versions = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return versions;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<Component>> getProjectComponents(final String projectKey) {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT, projectKey, COMPONENTS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<Component>>() {
                }.getType();
                List<Component> components = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return components;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Meta> getIssueTypesMetaForProject(final String projectKey) {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, CREATEMETA);
            uriBuilder.addParameter(PROJECTKEYS, projectKey);
            uriBuilder.addParameter(EXPAND, "projects.issuetypes.fields");
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Meta metabean = gson.fromJson(jsonReader, Meta.class);
                restApiCall.release();
                return metabean;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Project> createProject(Project project) {
        return null;
    }

    @Override
    public Future<ProjectCategory> createProjectCategory(String name, String description) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(PROJECTCATEGORY);
            ProjectCategory projectCategory = new ProjectCategory();
            projectCategory.setName(name);
            projectCategory.setDescription(description);
            String body = projectCategory.toString();
            RestApiCall restApiCall = doPost(uriBuilder.build(), body);
            int statusCode = restApiCall.getStatusCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                JsonReader jsonReader = restApiCall.getJsonReader();
                ProjectCategory category = gson.fromJson(jsonReader, ProjectCategory.class);
                restApiCall.release();
                return category;
            }else{
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<List<ProjectCategory>> getAllProjectCategories() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(PROJECTCATEGORY);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if(statusCode == HttpURLConnection.HTTP_OK){
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<ProjectCategory>>() {
                }.getType();
                List<ProjectCategory> projectCategories = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return projectCategories;
            }
            else{
                throw restApiCall.buildException();
            }
        });
    }
}
