package com.github.cschulc.jirarestservice.domain;

import com.github.cschulc.jirarestservice.util.GsonHelper;

/**
 * @author Christian Schulze
 */
public class BaseJsonBean {

    @Override
    public String toString() {
        return GsonHelper.toJson(this);
    }
}
