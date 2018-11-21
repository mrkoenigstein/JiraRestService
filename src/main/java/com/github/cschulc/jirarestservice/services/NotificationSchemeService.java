package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.notification.NotificationSchemeBean;
import com.github.cschulc.jirarestservice.domain.notification.NotifictaionSchemesBean;

import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public interface NotificationSchemeService {

    Future<NotifictaionSchemesBean> getNotificationSchemes(int startAt, int maxResults, String expand);

    Future<NotificationSchemeBean> getNotificationScheme(String id, String expand);
}
