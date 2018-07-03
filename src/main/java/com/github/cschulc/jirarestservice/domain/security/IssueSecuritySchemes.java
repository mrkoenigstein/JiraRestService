package com.github.cschulc.jirarestservice.domain.security;

import com.github.cschulc.jirarestservice.domain.BaseJson;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 08:56
 */
public class IssueSecuritySchemes extends BaseJson {

    @Expose
    private List<IssueSecurityScheme> issueSecuritySchemes = new ArrayList<>();

    public List<IssueSecurityScheme> getIssueSecuritySchemes() {
        return issueSecuritySchemes;
    }

    public void setIssueSecuritySchemes(List<IssueSecurityScheme> issueSecuritySchemes) {
        this.issueSecuritySchemes = issueSecuritySchemes;
    }
}
