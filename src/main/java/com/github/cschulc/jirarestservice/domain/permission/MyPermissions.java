package com.github.cschulc.jirarestservice.domain.permission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyPermissions {

    @Expose
    @SerializedName("permissions")
    private Permissions permissions;

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }
}
