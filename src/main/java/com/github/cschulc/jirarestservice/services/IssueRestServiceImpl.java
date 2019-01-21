package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.*;
import com.github.cschulc.jirarestservice.domain.ErrorBean;
import com.github.cschulc.jirarestservice.domain.update.IssueUpdateBean;
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


import static com.github.cschulc.jirarestservice.misc.RestParams.*;
import static com.github.cschulc.jirarestservice.misc.RestPaths.*;

public class IssueRestServiceImpl extends BaseRestService implements IssueRestService {

    private static final String SEPARATOR = ",";

    public IssueRestServiceImpl(JiraRestService service, ExecutorService executorService) {
        super(service);
        this.executorService = executorService;
    }

    @Override
    public Future<IssueResponseBean> createIssue(IssueBean issue) {
        Validate.notNull(issue);
        return executorService.submit(() -> {
            String json = gson.toJson(issue);
            URIBuilder uriBuilder = buildPath(ISSUE);
            RestApiCall restApiCall = doPost(uriBuilder.build(), json);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK
                    || statusCode == HttpURLConnection.HTTP_CREATED) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                IssueBean issueBean = gson.fromJson(jsonReader,
                        IssueBean.class);
                restApiCall.release();
                return new IssueResponseBean(issueBean.getKey());
            } else if (statusCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                ErrorBean error = gson
                        .fromJson(jsonReader, ErrorBean.class);
                restApiCall.release();
                return new IssueResponseBean(error);
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<IssueBean> getIssueByKey(String issueKey) {
        Validate.notNull(issueKey);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                final IssueBean issueBean = gson.fromJson(jsonReader,
                        IssueBean.class);
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
    public Future<IssueBean> updateIssue(String issueKey, IssueUpdateBean issueUpdate) {
        Validate.notNull(issueKey);
        Validate.notNull(issueUpdate);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
            String body = gson.toJson(issueUpdate);
            RestApiCall restApiCall = doPut(uriBuilder.build(), body);
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_NO_CONTENT) {
                final Future<IssueBean> issueByKey = getIssueByKey(issueKey);
                restApiCall.release();
                return issueByKey.get();
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<IssueBean> getIssueByKey(String issueKey, List<String> fields, List<String> expand) {
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUE, issueKey);
            if (fields != null && !fields.isEmpty()) {
                String fieldsParam = StringUtils.join(fields, SEPARATOR);
                uriBuilder.addParameter(FIELDS, fieldsParam);
            }
            if (expand != null && !expand.isEmpty()) {
                String expandParam = StringUtils.join(expand, SEPARATOR);
                uriBuilder.addParameter(EXPAND, expandParam);
            }
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                IssueBean issue = extractIssueBean(restApiCall);
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
    public Future<AttachmentBean> getAttachment(String id) {
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ATTACHMENT, id);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                AttachmentBean attachment = gson.fromJson(jsonReader,
                        AttachmentBean.class);
                restApiCall.release();
                return attachment;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<List<AttachmentBean>> saveAttachmentToIssue(String issuekey, File... files) {
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
                Type listType = new TypeToken<ArrayList<AttachmentBean>>() {
                }.getType();
                List<AttachmentBean> attachments = gson.fromJson(jsonReader, listType);
                restApiCall.release();
                return attachments;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public boolean transferWorklogInIssue(String issueKey, WorklogBean worklog) throws JiraRestException, IOException, URISyntaxException {
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
        UpdateTransitionBean updateTransition = new UpdateTransitionBean();
        TransitionBean transition = new TransitionBean();
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
    public Future<List<TransitionBean>> getIssueTransitionsByKey(String issueKey) {
        Validate.notNull(issueKey);
        return executorService.submit(() -> {
            URIBuilder uriBuilder = buildPath(ISSUE, issueKey, TRANSITIONS);
            uriBuilder.addParameter(EXPAND, TRANSITIONS_FIELDS);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                final IssueBean issue = extractIssueBean(restApiCall);
                restApiCall.release();
                return issue.getTransitions();
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<CommentsBean> getCommentsByIssue(String issueKey) {
        Validate.notNull(issueKey);
        return executorService.submit(() -> {

            URIBuilder uriBuilder = buildPath(ISSUE, issueKey, COMMENT);
            RestApiCall restApiCall = doGet(uriBuilder.build());
            int statusCode = restApiCall.getStatusCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                JsonReader jsonReader = restApiCall.getJsonReader();
                CommentsBean comments = gson.fromJson(jsonReader,
                        CommentsBean.class);
                restApiCall.release();
                return comments;
            } else {
                throw restApiCall.buildException();
            }
        });
    }

    @Override
    public Future<Boolean> addCommentToIssue(String issueKey, CommentBean comment) {
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


    private IssueBean extractIssueBean(RestApiCall restApiCall) throws IOException {
        JsonReader jsonReader = restApiCall.getJsonReader();
        return gson.fromJson(jsonReader, IssueBean.class);
    }
}
