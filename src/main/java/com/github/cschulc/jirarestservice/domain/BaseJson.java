package com.github.cschulc.jirarestservice.domain;

import com.github.cschulc.jirarestservice.util.GsonHelper;

/**
 * @author Christian Schulze
 */
public class BaseJson {

    @Override
    public String toString() {
        return GsonHelper.toJson(this);
    }
}
