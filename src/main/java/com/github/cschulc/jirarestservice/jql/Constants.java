package com.github.cschulc.jirarestservice.jql;

public class Constants {

    public static final String PROJECT = "project";

    public static final String ORDER_BY = "ORDER_BY";

    public static final String ISSUETYPE = "issuetype";

    public static final String STATUS = "status";

    public static final String AND = "and";

    public static final String OR = "or";

    // IssueBean FieldEnum Names für die JQL Suche

    public static final String FIELD_SUMMARY = "summary";

    public static final String FIELD_ISSUETYPE = "issuetype";

    public static final String FIELD_STATUS = "status";

    public static final String FIELD_DUEDATE = "duedate";

    public static final String FIELD_PRIORITY = "priority";

    //IssueBean StatusBean für die JQL Suche

    public static final String STATUS_OPEN = "open";

    public static final String STATUS_CLOSED = "closed";

    public static final String STATUS_RESOLVED = "resolved";

    public static final String STATUS_IN_PROGRESS = "\"in progress\"";

    public static final String STATUS_REOPENED = "reopened";

    //IssueBean TypeBean für die JQL Suche

    public static final String ISSUETYPE_IMPROVEMENT = "improvement";

    public static final String ISSUETYPE_BUG = "bug";

    public static final String ISSUETYPE_NEW_FEATURE = "\"new feature\"";

    public static final String ISSUETYPE_SUBTASK = "sub-task";

    public static final String ISSUETYPE_TASK = "task";

    //PriorityBean für die SQL Suche

    public static final String PRIORITY_MAJOR = "major";

    public static final String PRIORITY_BLOCKER = "blocker";

    public static final String PRIORITY_CRITICAL = "critical";

    public static final String PRIORITY_MINOR = "minor";

    public static final String PRIORITY_TRIVIAL = "trivial";
}
