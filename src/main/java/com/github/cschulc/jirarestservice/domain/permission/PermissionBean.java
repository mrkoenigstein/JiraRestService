package com.github.cschulc.jirarestservice.domain.permission;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

public class PermissionBean extends BaseBean {

    @Expose
    private HolderBean holder;

    @Expose
    private String permission;

    public HolderBean getHolder() {
        return holder;
    }

    public void setHolder(HolderBean holder) {
        this.holder = holder;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
