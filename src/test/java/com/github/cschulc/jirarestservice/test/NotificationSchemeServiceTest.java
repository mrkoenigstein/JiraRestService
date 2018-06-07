package com.github.cschulc.jirarestservice.test;

import com.github.cschulc.jirarestservice.domain.notification.NotificationScheme;
import com.github.cschulc.jirarestservice.domain.notification.NotifictaionSchemes;
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
        Future<NotifictaionSchemes> future = restService.getNotificationSchemeService().getNotificationSchemes(0, 50, StringUtils.EMPTY);
        NotifictaionSchemes notifictaionSchemes = future.get();
        Assert.assertNotNull(notifictaionSchemes);
    }

    @Test
    public void testGetNotificationScheme() throws ExecutionException, InterruptedException {
        Future<NotificationScheme> future = restService.getNotificationSchemeService().getNotificationScheme("10000", StringUtils.EMPTY);
        NotificationScheme notificationScheme = future.get();
        Assert.assertNotNull(notificationScheme);
    }
}
