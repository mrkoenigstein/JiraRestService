package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.user.CreateUser;
import com.github.cschulc.jirarestservice.domain.user.User;
import com.github.cschulc.jirarestservice.domain.permission.MyPermissions;
import com.github.cschulc.jirarestservice.domain.user.UserResult;
import com.github.cschulc.jirarestservice.misc.Experimental;
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

    /**
     * Create user. By default created user will not be notified with email. If password field is not set then password will be randomly generated.
     *
     * @param user The User to create
     * @return The created User or Null
     */
    @Experimental
    Future<User> createUser(CreateUser user);

    /**
     * Returns a list of users that match the query. This resource cannot be accessed anonymously.
     *
     * @param keys the keys of the users to be returned
     * @param maxResults the maximum number of users to return (defaults to 10). The maximum allowed value is 200.
     * @param startAt the index of the first user to return (0-based)
     * @param usernames the usernames of the users to be returned
     * @return
     */
    @Experimental
    Future<UserResult> getUserBulk(String[] keys, int maxResults, int startAt, String[] usernames);
}
