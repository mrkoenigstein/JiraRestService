package com.github.cschulc.jirarestservice.domain.update;

public enum Operation {
    SET("set"),EDIT("edit"),REMOVE("remove");

    private String name;

    Operation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
