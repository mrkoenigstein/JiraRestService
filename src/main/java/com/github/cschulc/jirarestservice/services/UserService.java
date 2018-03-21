package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.User;
import com.github.cschulc.jirarestservice.domain.permission.MyPermissions;
import com.github.cschulc.jirarestservice.misc.JiraRestException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;

public interface UserService {

    /**
     * Returns a List of User which are assignable to Issue in a Project
     *
     * @param projectKey the projectkey
     * @param startAt start at position (0-based) can be null the default (0)
     * @param maxResults Number of Results (default 50) can be null then default (50)
     * @return The List of a assignable Users, or an Empty List if the logged in User has no permission to get assign Issues
     */
    Future<List<User>> getAssignableUserForProject(String projectKey, Integer startAt, Integer maxResults) throws JiraRestException, IOException;


    /**
     * Returns a List of User which are assignable to an Issue
     *
     * @param issueKey The Issuekey
     * @param startAt start at position (0-based) can be null the default (0)
     * @param maxResults Number of Results (default 50) can be null then default (50)
     * @return The List of a assignable Users, or an Empty List if the logged in User has no permission to get assign Issues
     */
    Future<List<User>> getAssignableUsersForIssue(String issueKey, Integer startAt, Integer maxResults) throws JiraRestException, IOException;

    /**
     * Returns a User by his username
     *
     * @param username The username of the User
     * @return The User for the username or null if the logged in User has no permission to get another user
     */
    Future<User> getUserByUsername(String username);

    /**
     * Returns the logged in remote user.
     *
     * @return logged in user
     * @throws JiraRestException
     */
    Future<User> getLoggedInRemoteUser() throws JiraRestException, IOException;

    /**
     * Get the Permissions for the logged in User.
     * This contains all Permissons, every permission has a flag if it is set or unset.
     *
     * @return Permissions with all Permission,
     */
    Future<MyPermissions> getMyPermissions();
}
