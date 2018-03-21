package com.github.cschulc.jirarestservice.domain.permission;

import com.github.cschulc.jirarestservice.domain.Base;
import org.apache.commons.lang3.StringUtils;

public class Permission extends Base {

    private String key = StringUtils.EMPTY;

    private String type = StringUtils.EMPTY;

    private String description = StringUtils.EMPTY;

    private boolean havePermission;

    private boolean deprecatedKey;

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

    public boolean isDeprecatedKey() {
        return deprecatedKey;
    }

    public void setDeprecatedKey(boolean deprecatedKey) {
        this.deprecatedKey = deprecatedKey;
    }
}
