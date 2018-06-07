package com.github.cschulc.jirarestservice.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Christian Schulze
 */
public class BaseJson {

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this);
    }
}
