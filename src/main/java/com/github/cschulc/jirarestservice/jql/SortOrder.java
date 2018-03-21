package com.github.cschulc.jirarestservice.jql;

public enum SortOrder {

    ASC("asc"), DESC("desc");

    private final String order;

    SortOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return this.order;
    }
}
