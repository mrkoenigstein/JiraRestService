package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.permission.PermissionSchemeBean;
import com.github.cschulc.jirarestservice.domain.permission.PermissionSchemesBean;

import java.util.concurrent.Future;

/**
 * @author Christian Schulze
 */
public interface PermissionSchemeRestService {

    Future<PermissionSchemesBean> getPermissionsSchemes();

    Future<PermissionSchemeBean> getPermissionScheme(String id);
}
