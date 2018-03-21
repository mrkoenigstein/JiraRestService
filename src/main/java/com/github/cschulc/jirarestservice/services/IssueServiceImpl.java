package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.*;
import com.github.cschulc.jirarestservice.domain.Error;
import com.github.cschulc.jirarestservice.domain.update.IssueUpdate;
import com.github.cschulc.jirarestservice.misc.JiraRestException;
import com.github.cschulc.jirarestservice.util.RestApiCall;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.http.HttpEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class IssueServiceImpl extends BaseService implements IssueService {

    private static final String SEPARATOR = ",";

    public IssueServiceImpl(JiraRestService service, ExecutorService executorService) {
        super(service);
        this.executorService = executorService;
    }

    @Override
    public Future<IssueResponse> createIssue(Issue issue) {
        Validate.notNull(issue);
        return executorService.submit(() -> {
            String json = gson.toJson(issue);
            URIBuilder uriBuilder = buildPath(ISSUE);
            RestApiCall restApiCall = doPost(uriBuilder.build(), json);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK
                    || statusCode == HttpURLConnection.HTTP_CREATED) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Issue issueBean = gson.fromJson(jsonReader,
                        Issue.class);
                restApiCall.release();
                return new IssueResponse(issueBean.getKey());
            } else if (statusCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Error error = gson
                        .fromJson(jsonReader, Error.class);
                restApiCall.release();
                return new IssueResponse(error);
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Issue> getIssueByKey(String issueKey) {
        Validate.notNull(issueKey);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                final Issue issueBean = gson.fromJson(jsonReader,
                        Issue.class);
                restApiCall.release();
                return issueBean;
            } else if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                restApiCall.release();
                return null;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Issue> updateIssue(String issueKey, IssueUpdate issueUpdate) {
        Validate.notNull(issueKey);
        Validate.notNull(issueUpdate);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
            String body = gson.toJson(issueUpdate);
            RestApiCall restApiCall = doPut(uriBuilder.build(), body);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_NO_CONTENT) {
                final Future<Issue> issueByKey = getIssueByKey(issueKey);
                restApiCall.release();
                return issueByKey.get();
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Issue> getIssueByKey(String issueKey, List<String> fields, List<String> expand) {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
            if (fields != null && fields.isEmpty() == false) {
                String fieldsParam = StringUtils.join(fields, SEPARATOR);
                uriBuilder.addParameter(FIELDS, fieldsParam);
            }
            if (expand != null && expand.isEmpty() == false) {
                String expandParam = StringUtils.join(expand, SEPARATOR);
                uriBuilder.addParameter(EXPAND, expandParam);
            }
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                Issue issue = extractIssueBean(restApiCall);
                restApiCall.release();
                return issue;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Byte[]> getAttachment(URI uri) {
        Validate.notNull(uri);
        return executorService.submit(() -> {
            RestApiCall restApiCall = doGetForFile(uri);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                HttpEntity entity = restApiCall.getHttpEntity();
                InputStream inputStream = entity.getContent();
                byte[] bytes = IOUtils.toByteArray(inputStream);
                restApiCall.release();
                return ArrayUtils.toObject(bytes);
            }
            restApiCall.release();
            return null;
        });
    }

    @Override
    public Future<Attachment> getAttachment(String id) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ATTACHMENT, id);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Attachment attachment = gson.fromJson(jsonReader,
                        Attachment.class);
                restApiCall.release();
                return attachment;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<List<Attachment>> saveAttachmentToIssue(String issuekey, File... files) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, issuekey, ATTACHMENTS);
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            for (File file : files) {
                FileBody fileBody = new FileBody(file, ContentType.MULTIPART_FORM_DATA);
                multipartEntityBuilder.addPart("file", fileBody);
            }
            HttpEntity entity = multipartEntityBuilder.build();
            RestApiCall restApiCall = doPostForFile(uriBuilder.build(), entity);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Type listType = new TypeToken<ArrayList<Attachment>>() {
                }.getType();
                List<Attachment> attachments = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return attachments;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public boolean transferWorklogInIssue(String issueKey, Worklog worklog) throws JiraRestException, IOException, URISyntaxException {
        Validate.notNull(issueKey);
        Validate.notNull(worklog);

        String json = gson.toJson(worklog);
        URIBuilder uriBuilder = buildPath(ISSUE, issueKey, WORKLOG);
        RestApiCall restApiCall = doPost(uriBuilder.build(), json);
        int statusCode = restApiCall.getStatusCode();
        if (statusCode == HttpURLConnection.HTTP_CREATED) {
            restApiCall.release();
            return true;
        } else {
            throw restApiCall.buildException();
        }
    }

    @Override
    public boolean updateIssueTransitionByKey(String issueKey, int transitionId) throws JiraRestException, IOException, URISyntaxException {
        Validate.notNull(issueKey);
        UpdateTransition updateTransition = new UpdateTransition();
        Transition transition = new Transition();
        transition.setId(String.valueOf(transitionId));
        updateTransition.setTransition(transition);
        URIBuilder uriBuilder = buildPath(ISSUE, issueKey, TRANSITIONS);
        String body = updateTransition.toString();
        RestApiCall restApiCall = doPost(uriBuilder.build(), body);
        int statusCode = restApiCall.getStatusCode();
        if (statusCode == HttpURLConnection.HTTP_NO_CONTENT) {
            restApiCall.release();
            return true;
        } else {
            throw restApiCall.buildException();
        }
    }

    @Override
    public Future<List<Transition>> getIssueTransitionsByKey(String issueKey) {
        Validate.notNull(issueKey);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, issueKey, TRANSITIONS);
            uriBuilder.addParameter(EXPAND, TRANSITIONS_FIELDS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                final Issue issue = extractIssueBean(restApiCall);
                restApiCall.release();
                return issue.getTransitions();
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Comments> getCommentsByIssue(String issueKey) {
        Validate.notNull(issueKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUE, issueKey, COMMENT);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                Comments comments = gson.fromJson(jsonReader,
                        Comments.class);
                restApiCall.release();
                return comments;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Boolean> addCommentToIssue(String issueKey, Comment comment) {
        Validate.notNull(issueKey);
        Validate.notNull(comment);
        return executorService.submit(() -> {
            final String json = gson.toJson(comment);
            final URIBuilder uriBuilder = buildPath(ISSUE, issueKey, COMMENT);
            RestApiCall restApiCall = doPost(uriBuilder.build(), json);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_CREATED) {
                restApiCall.release();
                return Boolean.TRUE;
            } else {
                throw restApiCall.buildException();
            }
        });
    }


    private Issue extractIssueBean(RestApiCall restApiCall) throws IOException {
        JsonReader jsonReader = restApiCall.getJsonReader();
        return gson.fromJson(jsonReader, Issue.class);
    }
}
