package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemeBean;
import com.github.cschulc.jirarestservice.domain.security.IssueSecuritySchemesBean;

import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 08:54
 */
public interface IssueSecuritySchemeService {

    /**
     * Returns all issue security schemes that are defined.
     *
     * @return IssueSecuritySchemesBean as root object
     */
    Future<IssueSecuritySchemesBean> getIssueSecuritySchemes();

    /**
     * Returns the issue security scheme along with that are defined.
     *
     * @param id The id of the IssueSecuritySchemeBean
     * @return IssueSecuritySchemeBean
     */
    Future<IssueSecuritySchemeBean> getIssueSecurityScheme(String id);
}
