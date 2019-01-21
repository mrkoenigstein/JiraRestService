package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.AttachmentMetaBean;
import com.github.cschulc.jirarestservice.domain.IssuetypeBean;
import com.github.cschulc.jirarestservice.domain.PriorityBean;
import com.github.cschulc.jirarestservice.domain.StatusBean;
import com.github.cschulc.jirarestservice.domain.customFields.CustomFieldType;
import com.github.cschulc.jirarestservice.domain.field.CreateFieldBean;
import com.github.cschulc.jirarestservice.domain.field.FieldBean;
import com.github.cschulc.jirarestservice.domain.system.ConfigurationBean;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class SystemRestServiceTest extends BaseTest {

    private static final int DEFAULT_NUMBER_OF_ISSUETYPES = 4;
    private static final int DEFAULT_NUMBER_OF_STATES = 3;
    private static final int DEFAULT_NUMBER_OF_PRIORITIES = 5;
    private static final int DEFAULT_NUMBER_OF_FIELDS = 40;
    private static final int DEFAULT_UPLOAD_LIMIT = 10485760;
    private static final int DEFAULT_WORKING_HOURS_PER_DAY = 8;

    @Test
    public void testGetConfiguration() throws InterruptedException, ExecutionException {
        Future<ConfigurationBean> future = restService.getSystemRestService().getConfiguration();
        ConfigurationBean configuration = future.get();
        Assert.assertNotNull(configuration);
        Assert.assertNotNull(configuration.getTimeTrackingConfiguration());
        Assert.assertEquals(DEFAULT_WORKING_HOURS_PER_DAY, configuration.getTimeTrackingConfiguration().getWorkingHoursPerDay().intValue());
    }

    @Test
    public void testGetIssueType() throws InterruptedException, ExecutionException {
        final Future<List<IssuetypeBean>> future = restService.getSystemRestService().getIssueTypes();
        final List<IssuetypeBean> issuetypes = future.get();
        Assert.assertNotNull(issuetypes);
        Assert.assertFalse(issuetypes.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_ISSUETYPES, issuetypes.size());
    }

    @Test
    public void testGetPriorities() throws InterruptedException, ExecutionException {
        final Future<List<PriorityBean>> future = restService.getSystemRestService().getPriorities();
        final List<PriorityBean> priorities = future.get();
        Assert.assertNotNull(priorities);
        Assert.assertFalse(priorities.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_PRIORITIES, priorities.size());
    }

    @Test
    public void testGetStates() throws InterruptedException, ExecutionException {
        final Future<List<StatusBean>> future = restService.getSystemRestService().getStates();
        final List<StatusBean> statuss = future.get();
        Assert.assertNotNull(statuss);
        Assert.assertFalse(statuss.isEmpty());
        Assert.assertEquals(DEFAULT_NUMBER_OF_STATES, statuss.size());
    }


    @Test
    public void testGetFields() throws InterruptedException, ExecutionException {
        final Future<List<FieldBean>> future = restService.getSystemRestService().getAllFields();
        final List<FieldBean> fields = future.get();
        Assert.assertNotNull(fields);
        Assert.assertFalse(fields.isEmpty());
        int numberOfFields = 0;
        for (FieldBean field : fields) {
            if(!field.getCustom()){
                numberOfFields = numberOfFields + 1;
            }
        }
        Assert.assertEquals(DEFAULT_NUMBER_OF_FIELDS, numberOfFields);
    }


    @Test
    public void testGetCustomFields() throws InterruptedException, ExecutionException {
        final Future<List<FieldBean>> future = restService.getSystemRestService().getAllCustomFields();
        final List<FieldBean> fields = future.get();
        Assert.assertNotNull(fields);
    }

    @Test
    public void testGetCustomFieldById() throws InterruptedException, ExecutionException {
        Future<FieldBean> future = restService.getSystemRestService().getCustomFieldById("10000");
        FieldBean field = future.get();
        Assert.assertNotNull(field);
    }

    @Test
    public void testCreateCustomField() throws InterruptedException, ExecutionException {
        CreateFieldBean createField = new CreateFieldBean();
        createField.setName("New Custom FieldBean");
        createField.setDescription("Custom field for picking groups");
        createField.setType(CustomFieldType.GROUP.getJiraName());
        Future<FieldBean> future = restService.getSystemRestService().createCustomField(createField);
        FieldBean field = future.get();
        Assert.assertNotNull(field);
        Assert.assertEquals(createField.getName(), field.getName());
    }

    @Test
    @Ignore
    public void testGetAttachmentMeta() throws InterruptedException, ExecutionException {
        final Future<AttachmentMetaBean> future = restService.getSystemRestService().getAttachmentMeta();
        final AttachmentMetaBean attachmentMeta = future.get();
        Assert.assertNotNull(attachmentMeta);
        Assert.assertEquals(DEFAULT_UPLOAD_LIMIT, attachmentMeta.getUploadLimit());
    }
}
