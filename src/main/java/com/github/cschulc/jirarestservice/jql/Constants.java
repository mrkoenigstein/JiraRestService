package com.github.cschulc.jirarestservice.jql;

public interface Constants {

    String PROJECT = "project";

    String ORDER_BY = "ORDER_BY";

    String ISSUETYPE = "issuetype";

    String STATUS = "status";

    String AND = "and";

    String OR = "or";

    // Issue FieldEnum Names für die JQL Suche

    String FIELD_SUMMARY = "summary";

    String FIELD_ISSUETYPE = "issuetype";

    String FIELD_STATUS = "status";

    String FIELD_DUEDATE = "duedate";

    String FIELD_PRIORITY = "priority";

    //Issue Status für die JQL Suche

    String STATUS_OPEN = "open";

    String STATUS_CLOSED = "closed";

    String STATUS_RESOLVED = "resolved";

    String STATUS_IN_PROGRESS = "\"in progress\"";

    String STATUS_REOPENED = "reopened";

    //Issue Type für die JQL Suche

    String ISSUETYPE_IMPROVEMENT = "improvement";

    String ISSUETYPE_BUG = "bug";

    String ISSUETYPE_NEW_FEATURE = "\"new feature\"";

    String ISSUETYPE_SUBTASK = "sub-task";

    String ISSUETYPE_TASK = "task";

    //Priority für die SQL Suche

    String PRIORITY_MAJOR = "major";

    String PRIORITY_BLOCKER = "blocker";

    String PRIORITY_CRITICAL = "critical";

    String PRIORITY_MINOR = "minor";

    String PRIORITY_TRIVIAL = "trivial";
}
