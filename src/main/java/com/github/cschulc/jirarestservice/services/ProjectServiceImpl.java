package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.ComponentBean;
import com.github.cschulc.jirarestservice.domain.ProjectBean;
import com.github.cschulc.jirarestservice.domain.VersionBean;
import com.github.cschulc.jirarestservice.domain.meta.MetaBean;
import com.github.cschulc.jirarestservice.domain.project.CreateProjectBean;
import com.github.cschulc.jirarestservice.domain.project.ProjectCategoryBean;
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

    public Future<ProjectBean> getProjectByKey(final String projectKey, String expand) {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT, projectKey);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                ProjectBean project = gson.fromJson(jsonReader, ProjectBean.class);
                restApiCall.release();
                return project;
            } else {
                throw restApiCall.buildException();
            }
        });

    }


    public Future<List<ProjectBean>> getAllProjects() {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<ProjectBean>>() {
                }.getType();
                List<ProjectBean> projects = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return projects;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<VersionBean>> getProjectVersions(final String projectKey) {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT, projectKey, VERSIONS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<VersionBean>>() {
                }.getType();
                List<VersionBean> versions = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return versions;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    public Future<List<ComponentBean>> getProjectComponents(final String projectKey) {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(PROJECT, projectKey, COMPONENTS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<ComponentBean>>() {
                }.getType();
                List<ComponentBean> components = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return components;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<MetaBean> getIssueTypesMetaForProject(final String projectKey) {
        Validate.notNull(projectKey);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, CREATEMETA);
            uriBuilder.addParameter(PROJECTKEYS, projectKey);
            uriBuilder.addParameter(EXPAND, "projects.issuetypes.fields");
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                MetaBean metabean = gson.fromJson(jsonReader, MetaBean.class);
                restApiCall.release();
                return metabean;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<ProjectBean> createProject(CreateProjectBean createProject) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(PROJECT);
            String body = createProject.toString();
            RestApiCall restApiCall = doPost(uriBuilder.build(), body);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_CREATED) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                ProjectBean project = gson.fromJson(jsonReader, ProjectBean.class);
                restApiCall.release();
                return project;
            } else {
                return null;
            }
        });
    }

    @Override
    public Future<ProjectCategoryBean> createProjectCategory(String name, String description) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(PROJECTCATEGORY);
            ProjectCategoryBean projectCategory = new ProjectCategoryBean();
            projectCategory.setName(name);
            projectCategory.setDescription(description);
            String body = projectCategory.toString();
            RestApiCall restApiCall = doPost(uriBuilder.build(), body);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                ProjectCategoryBean category = gson.fromJson(jsonReader, ProjectCategoryBean.class);
                restApiCall.release();
                return category;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<List<ProjectCategoryBean>> getAllProjectCategories() {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(PROJECTCATEGORY);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<ProjectCategoryBean>>() {
                }.getType();
                List<ProjectCategoryBean> projectCategories = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return projectCategories;
            } else {
                throw restApiCall.buildException();
            }
        });
    }
}
