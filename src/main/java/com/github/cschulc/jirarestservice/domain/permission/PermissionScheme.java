package com.github.cschulc.jirarestservice.domain.permission;

import com.github.cschulc.jirarestservice.domain.Base;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Christian Schulze
 */
public class PermissionScheme extends Base {

    private String description = StringUtils.EMPTY;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
