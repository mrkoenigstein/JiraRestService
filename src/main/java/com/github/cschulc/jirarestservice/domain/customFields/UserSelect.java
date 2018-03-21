package com.github.cschulc.jirarestservice.domain.customFields;

import com.github.cschulc.jirarestservice.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserSelect extends CustomFieldBase {

    private List<User> users;

    public List<User> getUsers() {
        if(users == null){
            users = new ArrayList<>();
        }
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
