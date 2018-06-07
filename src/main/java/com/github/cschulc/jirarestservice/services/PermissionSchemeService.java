package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.permission.PermissionScheme;
import com.github.cschulc.jirarestservice.domain.permission.PermissionSchemes;

import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public interface PermissionSchemeService {

    Future<PermissionSchemes> getPermissionsSchemes();

    Future<PermissionScheme> getPermissionScheme(String id);
}
