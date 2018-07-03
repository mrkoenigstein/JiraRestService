package com.github.cschulc.jirarestservice.domain.permission;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 12:54
 */
public class UserPermission extends Base {

    @Expose
    private String key;

    @Expose
    private String type;

    @Expose
    private boolean deprecatedKey;

    @Expose
    private String description;

    @Expose
    private boolean havePermission;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDeprecatedKey() {
        return deprecatedKey;
    }

    public void setDeprecatedKey(boolean deprecatedKey) {
        this.deprecatedKey = deprecatedKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHavePermission() {
        return havePermission;
    }

    public void setHavePermission(boolean havePermission) {
        this.havePermission = havePermission;
    }
}
