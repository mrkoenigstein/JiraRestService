package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.*;
import com.github.cschulc.jirarestservice.domain.update.FieldOperation;
import com.github.cschulc.jirarestservice.domain.update.IssueUpdate;
import com.github.cschulc.jirarestservice.domain.update.Operation;
import com.github.cschulc.jirarestservice.jql.Constants;
import com.github.cschulc.jirarestservice.jql.FieldEnum;
import com.github.cschulc.jirarestservice.misc.JiraRestException;
import com.github.cschulc.jirarestservice.util.URIHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class IssueServiceTest extends BaseTest {

    private static final String NEW_LINE = System.getProperty("line.separator");

    @Test
    public void testGetIssueByKey() throws ExecutionException, InterruptedException {
        Future<Issue> future = restService.getIssueService().getIssueByKey(ISSUEKEY_TO_SEARCH);
        final Issue issue = future.get();
        Assert.assertNotNull(issue);
        Assert.assertEquals(ISSUEKEY_TO_SEARCH, issue.getKey());
    }

    @Test
    public void testGetIssueKeyWithFields() throws ExecutionException, InterruptedException {
        List<String> field = new ArrayList<>();
        field.add(FieldEnum.SUMMARY.getField());
        field.add(FieldEnum.DESCRIPTION.getField());
        List<String> expand = new ArrayList<>();
        expand.add(FieldEnum.RENDEREDFIELDS.getField());
        expand.add(FieldEnum.TRANSITIONS.getField());
        expand.add(FieldEnum.CHANGELOG.getField());
        final Future<Issue> future = restService.getIssueService().getIssueByKey(ISSUEKEY_TO_SEARCH, field, expand);
        Issue issue = future.get();
        Assert.assertNotNull(issue);
        Assert.assertNotNull(issue.getFields().getSummary());
        Assert.assertNotNull(issue.getFields().getDescription());
        Assert.assertNotNull(issue.getRenderedFields().getDescription());

    }

    @Test
    public void testGetAttachment() throws IOException, ExecutionException, InterruptedException {
        final Future<Issue> future = restService.getIssueService().getIssueByKey(ISSUEKEY_TO_SEARCH);
        final Issue issue = future.get();
        List<Attachment> attachments = issue.getFields().getAttachment();
        Assert.assertNotNull(attachments);
        Assert.assertFalse(attachments.isEmpty());
        Attachment attachment = attachments.get(0);
        String fileName = attachment.getFilename();
        String contentURI = attachment.getContent();
        URI uri = URIHelper.parseStringToURI(contentURI);
        final Future<Byte[]> future1 = restService.getIssueService().getAttachment(uri);
        final Byte[] attachmentBytes = future1.get();
        Assert.assertNotNull(attachmentBytes);
        OutputStream output = new FileOutputStream(fileName);
        final byte[] bytes = ArrayUtils.toPrimitive(attachmentBytes);
        output.write(bytes);
        output.flush();
        output.close();
    }

    @Test
    public void testCreateIssue() throws ExecutionException, InterruptedException {
        Issue issue = new Issue();
        Fields fields = new Fields();
        fields.setDescription("Test Description");
        fields.setSummary("Test Title");
        Project project = new Project();
        project.setKey("DEMO");
        fields.setProject(project);
        Issuetype issueType = new Issuetype();
        issueType.setName("Bug");
        fields.setIssuetype(issueType);
        Priority priority = new Priority();
        priority.setName(Constants.PRIORITY_MAJOR);
        fields.setPriority(priority);
        fields.setDuedate("2015-08-01");

        List<Component> componentBeen = new ArrayList<>();
        Component component1 = new Component();
        component1.setName("Komponente 1");
        componentBeen.add(component1);
        Component component2 = new Component();
        component2.setName("Komponente 2");
        componentBeen.add(component2);
        fields.setComponents(componentBeen);

        List<Version> versionBeen = new ArrayList<>();
        Version version1 = new Version();
        version1.setName("1.1");
        versionBeen.add(version1);
        Version version2 = new Version();
        version2.setName("1.0");
        versionBeen.add(version2);
        fields.setVersions(versionBeen);
        fields.setFixVersions(versionBeen);

        User user = new User();
        user.setName("admin");
        fields.setAssignee(user);
        List<String> labels = new ArrayList<>();
        labels.add("foobar");
        labels.add("inubit");
        fields.setLabels(labels);
        issue.setFields(fields);

        final Future<IssueResponse> future = restService.getIssueService().createIssue(issue);
        final IssueResponse issueResponse = future.get();
        if (issueResponse != null) {
            String issueKey = issueResponse.getKey();
            if (issueKey != null) {
                System.out.println(issueKey);
            } else {
                System.out.println(issueResponse.getError());
            }
        }


    }

    @Test
    @Ignore
    public void testSetLinkInEviroment() throws ExecutionException, InterruptedException {
        final Future<Issue> future = restService.getIssueService().getIssueByKey(ISSUEKEY_TO_SEARCH);
        final Issue issue = future.get();
        Assert.assertNotNull(issue);
        Assert.assertEquals(ISSUEKEY_TO_SEARCH, issue.getKey());
        String environment = issue.getFields().getEnvironment();
        String newEnviroment = environment + NEW_LINE + NEW_LINE + issue.getSelf();
        IssueUpdate issueUpdate = new IssueUpdate();
        Map<String, List<FieldOperation>> update = issueUpdate.getUpdate();
        List<FieldOperation> operations = new ArrayList<>();
        operations.add(new FieldOperation(Operation.SET.getName(), newEnviroment));
        update.put("environment", operations);
        final Future<Issue> updateFuture = restService.getIssueService().updateIssue(ISSUEKEY_TO_SEARCH, issueUpdate);
        final Issue updateIssue = updateFuture.get();
        String updateIssueEnvironment = updateIssue.getFields().getEnvironment();
        Assert.assertEquals(newEnviroment, updateIssueEnvironment);
    }

    @Test
    public void testGetTransitions() throws ExecutionException, InterruptedException {
        final Future<List<Transition>> future = restService.getIssueService().getIssueTransitionsByKey(ISSUEKEY_TO_SEARCH);
        final List<Transition> transitions = future.get();
        Assert.assertNotNull(transitions);
        Assert.assertFalse(transitions.isEmpty());
    }

    @Test
    public void testSaveAttachment() throws ExecutionException, InterruptedException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("fields.json")).getFile());
        File file2 = new File(Objects.requireNonNull(classLoader.getResource("customfields.json")).getFile());
        if (file.exists() == true) {
            Future<List<Attachment>> listFuture = restService.getIssueService().saveAttachmentToIssue(ISSUEKEY_TO_SEARCH, file, file2);
            List<Attachment> attachmentBeen = listFuture.get();
            Assert.assertFalse(attachmentBeen.isEmpty());
        }
    }

    @Test
    public void testAddCommentToIssue() throws URISyntaxException, IOException, JiraRestException, ExecutionException, InterruptedException {
        Comment comment = new Comment();
        comment.setBody("This is a new comment via restService.");
        Future<Boolean> future = restService.getIssueService().addCommentToIssue(ISSUEKEY_TO_SEARCH, comment);
        Boolean aBoolean = future.get();
        Assert.assertTrue(aBoolean);
    }
}
