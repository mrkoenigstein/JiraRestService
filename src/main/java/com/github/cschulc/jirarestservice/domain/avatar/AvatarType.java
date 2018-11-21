package com.github.cschulc.jirarestservice.domain.avatar;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 04.07.2018
 * Time: 10:23
 */
public enum AvatarType {
    ISSUETYPE("issuetype"), PROJECT("project"), USER("user");

    String name;

    AvatarType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
