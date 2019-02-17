/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.cschulc.jirarestservice.jql;

public class Constants {

    private Constants() {
    }

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
