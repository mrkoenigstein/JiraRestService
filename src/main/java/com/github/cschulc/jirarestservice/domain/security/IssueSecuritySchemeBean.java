package com.github.cschulc.jirarestservice.domain.security;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 08:54
 */
public class IssueSecuritySchemeBean extends BaseBean {

    @Expose
    private int defaultSecurityLevelId;

    @Expose
    private List<LevelBean> levels = new ArrayList<>();

    public int getDefaultSecurityLevelId() {
        return defaultSecurityLevelId;
    }

    public void setDefaultSecurityLevelId(int defaultSecurityLevelId) {
        this.defaultSecurityLevelId = defaultSecurityLevelId;
    }

    public List<LevelBean> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelBean> levels) {
        this.levels = levels;
    }
}
