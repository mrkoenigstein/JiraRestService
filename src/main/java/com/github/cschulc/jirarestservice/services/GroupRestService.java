package com.github.cschulc.jirarestservice.services;

import com.github.cschulc.jirarestservice.domain.groups.GroupBean;
import com.github.cschulc.jirarestservice.domain.groups.GroupsBean;

import java.util.concurrent.Future;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 25.06.2018
 * Time: 16:44
 */
public interface GroupRestService {

    Future<GroupsBean> findGroups(String query, String exclude, int maxResults, String username);

    Future<GroupBean> addUserToGroup(String groupname, String username);


}
