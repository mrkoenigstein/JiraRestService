package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.groups.Group;
import com.github.cschulc.jirarestservice.domain.groups.Groups;

import java.util.concurrent.Future;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 25.06.2018
 * Time: 16:44
 */
public interface GroupService {

    Future<Groups> getGroups(String query, String exclude, int maxResults, String username);

    Future<Group> addUserToGroup(String groupname, String username);
}
