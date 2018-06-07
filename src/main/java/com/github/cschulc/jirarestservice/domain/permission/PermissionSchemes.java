package com.github.cschulc.jirarestservice.domain.permission;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class PermissionSchemes {

    @Expose
    public List<Permission> permissionSchemes = new ArrayList<>();

    public List<Permission> getPermissionSchemes() {
        return permissionSchemes;
    }

    public void setPermissionSchemes(List<Permission> permissionSchemes) {
        this.permissionSchemes = permissionSchemes;
    }
}
