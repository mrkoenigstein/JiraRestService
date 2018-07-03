package com.github.cschulc.jirarestservice.domain.permission;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class PermissionSchemes {

    @Expose
    public List<PermissionScheme> permissionSchemes = new ArrayList<>();

    public List<PermissionScheme> getPermissionSchemes() {
        return permissionSchemes;
    }

    public void setPermissionSchemes(List<PermissionScheme> permissionSchemes) {
        this.permissionSchemes = permissionSchemes;
    }
}
