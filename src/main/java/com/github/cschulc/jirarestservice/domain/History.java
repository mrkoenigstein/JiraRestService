
package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class History {

    @Expose
    private String id;
    @Expose
    private User author;
    @Expose
    private String created;
    @Expose
    private List<Item> items = new ArrayList<>();

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
