package com.github.cschulc.jirarestservice.domain.security;

import com.github.cschulc.jirarestservice.domain.BaseJsonBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 08:56
 */
public class IssueSecuritySchemesBean extends BaseJsonBean {

    @Expose
    private List<IssueSecuritySchemeBean> issueSecuritySchemes = new ArrayList<>();

    public List<IssueSecuritySchemeBean> getIssueSecuritySchemes() {
        return issueSecuritySchemes;
    }

    public void setIssueSecuritySchemes(List<IssueSecuritySchemeBean> issueSecuritySchemes) {
        this.issueSecuritySchemes = issueSecuritySchemes;
    }
}
