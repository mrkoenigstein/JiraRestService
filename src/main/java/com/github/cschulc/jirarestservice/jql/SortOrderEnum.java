package com.github.cschulc.jirarestservice.jql;

public enum SortOrderEnum {

    ASC("asc"), DESC("desc");

    private final String order;

    SortOrderEnum(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return this.order;
    }
}
