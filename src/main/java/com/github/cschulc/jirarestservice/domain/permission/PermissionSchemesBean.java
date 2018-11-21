package com.github.cschulc.jirarestservice.domain.permission;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class PermissionSchemesBean {

    @Expose
    public List<PermissionSchemeBean> permissionSchemes = new ArrayList<>();

    public List<PermissionSchemeBean> getPermissionSchemes() {
        return permissionSchemes;
    }

    public void setPermissionSchemes(List<PermissionSchemeBean> permissionSchemes) {
        this.permissionSchemes = permissionSchemes;
    }
}
