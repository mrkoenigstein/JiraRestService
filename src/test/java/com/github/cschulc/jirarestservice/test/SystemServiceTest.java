package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.AttachmentMeta;
import com.github.cschulc.jirarestservice.domain.Issuetype;
import com.github.cschulc.jirarestservice.domain.Priority;
import com.github.cschulc.jirarestservice.domain.Status;
import com.github.cschulc.jirarestservice.domain.customFields.CustomFieldType;
import com.github.cschulc.jirarestservice.domain.field.CreateField;
import com.github.cschulc.jirarestservice.domain.field.Field;
import com.github.cschulc.jirarestservice.domain.system.Configuration;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class SystemServiceTest extends BaseTest {

    private static final int DEFAULT_NUMBER_OF_ISSUETYPES = 4;
    private static final int DEFAULT_NUMBER_OF_STATES = 3;
    private static final int DEFAULT_NUMBER_OF_PRIORITIES = 5;
    private static final int DEFAULT_NUMBER_OF_FIELDS = 40;
    private static final int DEFAULT_UPLOAD_LIMIT = 10485760;
    private static final int DEFAULT_WORKING_HOURS_PER_DAY = 8;

    @Test
    public void testGetConfiguration() throws InterruptedException, ExecutionException {
        Future<Configuration> future = restService.getSystemService().getConfiguration();
        Configuration configuration = future.get();
        Assert.assertNotNull(configuration);
        Assert.assertNotNull(configuration.getTimeTrackingConfiguration());
        Assert.assertEquals(DEFAULT_WORKING_HOURS_PER_DAY, configuration.getTimeTrackingConfiguration().getWorkingHoursPerDay().intValue());
    }

    @Test
    public void testGetIssueType() throws InterruptedException, ExecutionException {
        final Future<List<Issuetype>> future = restService.getSystemService().getIssueTypes();
        final List<Issuetype> issuetypes = future.get();
        Assert.assertNotNull(issuetypes);
        Assert.assertFalse(issuetypes.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_ISSUETYPES, issuetypes.size());
    }

    @Test
    public void testGetPriorities() throws InterruptedException, ExecutionException {
        final Future<List<Priority>> future = restService.getSystemService().getPriorities();
        final List<Priority> priorities = future.get();
        Assert.assertNotNull(priorities);
        Assert.assertFalse(priorities.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_PRIORITIES, priorities.size());
    }

    @Test
    public void testGetStates() throws InterruptedException, ExecutionException {
        final Future<List<Status>> future = restService.getSystemService().getStates();
        final List<Status> statuss = future.get();
        Assert.assertNotNull(statuss);
        Assert.assertFalse(statuss.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_STATES, statuss.size());
    }


    @Test
    public void testGetFields() throws InterruptedException, ExecutionException {
        final Future<List<Field>> future = restService.getSystemService().getAllFields();
        final List<Field> fields = future.get();
        Assert.assertNotNull(fields);
        Assert.assertFalse(fields.isEmpty());
        int numberOfFields = 0;
        for (Field field : fields) {
            if(field.getCustom() == false){
                numberOfFields = numberOfFields + 1;
            }
        }
        Assert.assertEquals(DEFAULT_NUMBER_OF_FIELDS, numberOfFields);
    }


    @Test
    public void testGetCustomFields() throws InterruptedException, ExecutionException {
        final Future<List<Field>> future = restService.getSystemService().getAllCustomFields();
        final List<Field> fields = future.get();
        Assert.assertNotNull(fields);
    }

    @Test
    public void testGetCustomFieldById() throws InterruptedException, ExecutionException {
        Future<Field> future = restService.getSystemService().getCustomFieldById("10000");
        Field field = future.get();
        Assert.assertNotNull(field);
    }

    @Test
    public void testCreateCustomField() throws InterruptedException, ExecutionException {
        CreateField createField = new CreateField();
        createField.setName("New Custom Field");
        createField.setDescription("Custom field for picking groups");
        createField.setType(CustomFieldType.GROUP.getJiraName());
        Future<Field> future = restService.getSystemService().createCustomField(createField);
        Field field = future.get();
        Assert.assertNotNull(field);
        Assert.assertEquals(createField.getName(), field.getName());
    }

    @Test
    @Ignore
    public void testGetAttachmentMeta() throws InterruptedException, ExecutionException {
        final Future<AttachmentMeta> future = restService.getSystemService().getAttachmentMeta();
        final AttachmentMeta attachmentMeta = future.get();
        Assert.assertNotNull(attachmentMeta);
        Assert.assertEquals(DEFAULT_UPLOAD_LIMIT, attachmentMeta.getUploadLimit());
    }
}
