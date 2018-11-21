package com.github.cschulc.jirarestservice.domain.permission;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Schulze
 */
public class PermissionSchemeBean extends BaseBean {

    @Expose
    private String description = StringUtils.EMPTY;

    @Expose
    private List<PermissionBean> permissions = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PermissionBean> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionBean> permissions) {
        this.permissions = permissions;
    }
}
