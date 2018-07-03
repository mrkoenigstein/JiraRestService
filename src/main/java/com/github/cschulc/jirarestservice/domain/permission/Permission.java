package com.github.cschulc.jirarestservice.domain.permission;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

public class Permission extends Base {

    @Expose
    private Holder holder;

    @Expose
    private String permission;

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
