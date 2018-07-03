package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.security.IssueSecurityScheme;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemes;

import java.util.concurrent.Future;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 08:54
 */
public interface IssueSecuritySchemeService {

    /**
     * Returns all issue security schemes that are defined.
     *
     * @return IssueSecuritySchemes as root object
     */
    Future<IssueSecuritySchemes> getIssueSecuritySchemes();

    /**
     * Returns the issue security scheme along with that are defined.
     *
     * @param id The id of the IssueSecurityScheme
     * @return IssueSecurityScheme
     */
    Future<IssueSecurityScheme> getIssueSecurityScheme(String id);
}
