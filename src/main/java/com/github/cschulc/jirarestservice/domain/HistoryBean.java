
package com.github.cschulc.jirarestservice.domain;

import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class HistoryBean {

    @Expose
    private String id;
    @Expose
    private UserBean author;
    @Expose
    private String created;
    @Expose
    private List<ItemBean> items = new ArrayList<>();

    public UserBean getAuthor() {
        return author;
    }

    public void setAuthor(UserBean author) {
        this.author = author;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemBean> getItems() {
        return items;
    }

    public void setItems(List<ItemBean> items) {
        this.items = items;
    }
}
