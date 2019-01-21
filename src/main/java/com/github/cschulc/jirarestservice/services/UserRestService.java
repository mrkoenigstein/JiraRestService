package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.user.CreateUserBean;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.github.cschulc.jirarestservice.domain.permission.MyPermissionsBean;
import com.github.cschulc.jirarestservice.misc.Experimental;
import com.github.cschulc.jirarestservice.misc.JiraRestException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;

public interface UserRestService {

    /**
     * Returns a List of UserBean which are assignable to IssueBean in a ProjectBean
     *
     * @param projectKey the projectkey
     * @param startAt start at position (0-based) can be null the default (0)
     * @param maxResults Number of Results (default 50) can be null then default (50)
     * @return The List of a assignable Users, or an Empty List if the logged in UserBean has no permission to get assign Issues
     */
    Future<List<UserBean>> getAssignableUserForProject(String projectKey, Integer startAt, Integer maxResults) throws JiraRestException, IOException;


    /**
     * Returns a List of UserBean which are assignable to an IssueBean
     *
     * @param issueKey The Issuekey
     * @param startAt start at position (0-based) can be null the default (0)
     * @param maxResults Number of Results (default 50) can be null then default (50)
     * @return The List of a assignable Users, or an Empty List if the logged in UserBean has no permission to get assign Issues
     */
    Future<List<UserBean>> getAssignableUsersForIssue(String issueKey, Integer startAt, Integer maxResults) throws JiraRestException, IOException;

    /**
     * Returns a UserBean by his username
     *
     * @param username The username of the UserBean
     * @return The UserBean for the username or null if the logged in UserBean has no permission to get another user
     */
    Future<UserBean> getUserByUsername(String username);

    /**
     * Returns the logged in remote user.
     *
     * @return logged in user
     * @throws JiraRestException throw if a errors occurs, details inside {@link JiraRestException}
     */
    Future<UserBean> getLoggedInRemoteUser() throws JiraRestException, IOException;

    /**
     * Get the PermissionsBean for the logged in UserBean.
     * This contains all Permissons, every permission has a flag if it is set or unset.
     *
     * @return PermissionsBean with all PermissionBean,
     */
    Future<MyPermissionsBean> getMyPermissions();

    /**
     * Create user. By default created user will not be notified with email. If password field is not set then password will be randomly generated.
     *
     * @param user The UserBean to create
     * @return The created UserBean or Null
     */
    @Experimental
    Future<UserBean> createUser(CreateUserBean user);

    /**
     * Returns a list of users that match the search string and property.
     *
     * PermissionsBean required: Browse users and groups global permission. Users with permission to access Jira can call this method, but empty search results are returned.
     *
     * @param includeActive Include active users.
     * @param includeInactive Include inactive users.
     * @param maxResults The maximum number of items to return per page. Maximum is 1000.
     * @param property A query string used to search properties. Property keys are specified by path, so property keys containing dot (.) or equals (=) characters cannot be used. The query string cannot be specified using a JSON object. Example: To search for the value of nested from {“something”:{“nested”:1,“other”:2}} use thepropertykey.something.nested=1.
     * @param startAt The index of the first item to return in a page of results (page offset).
     * @param username A query string used to search username, display name, and email address.
     *                 The string is matched to the starting letters of any word in the searched fields.
     *                 For example, ar matches to the username archie but not mark.
     *                 If you want to get all users pass a "." as username.
     * @return A {@link List} of {@link UserBean}
     */
    Future<List<UserBean>> findUsers(boolean includeActive, boolean includeInactive, int maxResults, String property, int startAt, String username);
}
