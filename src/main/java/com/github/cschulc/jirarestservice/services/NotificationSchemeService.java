package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.notification.NotificationScheme;
import com.github.cschulc.jirarestservice.domain.notification.NotifictaionSchemes;

import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public interface NotificationSchemeService {

    Future<NotifictaionSchemes> getNotificationSchemes(int startAt, int maxResults,String expand);

    Future<NotificationScheme> getNotificationScheme(String id, String expand);
}
