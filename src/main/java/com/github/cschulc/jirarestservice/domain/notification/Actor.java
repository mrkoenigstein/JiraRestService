package com.github.cschulc.jirarestservice.domain.notification;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Christian Schulze
 */
public class Actor extends Base {

    @Expose
    private String displayName = StringUtils.EMPTY;

    @Expose
    private String type = StringUtils.EMPTY;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
