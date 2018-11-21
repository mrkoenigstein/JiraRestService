package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.notification.NotificationSchemeBean;
import com.github.cschulc.jirarestservice.domain.notification.NotifictaionSchemesBean;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public class NotificationSchemeServiceTest extends BaseTest {

    @Test
    public void testGetNotificationSchemes() throws ExecutionException, InterruptedException {
        Future<NotifictaionSchemesBean> future = restService.getNotificationSchemeService().getNotificationSchemes(0, 50, StringUtils.EMPTY);
        NotifictaionSchemesBean notifictaionSchemes = future.get();
        Assert.assertNotNull(notifictaionSchemes);
    }

    @Test
    public void testGetNotificationScheme() throws ExecutionException, InterruptedException {
        Future<NotificationSchemeBean> future = restService.getNotificationSchemeService().getNotificationScheme("10000", StringUtils.EMPTY);
        NotificationSchemeBean notificationScheme = future.get();
        Assert.assertNotNull(notificationScheme);
    }
}
