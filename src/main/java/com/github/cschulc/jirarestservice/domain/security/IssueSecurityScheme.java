package com.github.cschulc.jirarestservice.domain.security;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 08:54
 */
public class IssueSecurityScheme extends Base {

    @Expose
    private int defaultSecurityLevelId;

    @Expose
    private List<Level> levels = new ArrayList<>();

    public int getDefaultSecurityLevelId() {
        return defaultSecurityLevelId;
    }

    public void setDefaultSecurityLevelId(int defaultSecurityLevelId) {
        this.defaultSecurityLevelId = defaultSecurityLevelId;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
}
