package com.github.cschulc.jirarestservice.jql;

public enum FieldEnum {

    ALL("*all", null),

    NAVIGABLE("*naviagble", null),

    /**
     * Issues that are assigned to a particular Affects VersionBean(s).
     * <p/>
     * <p>Examples:
     * <li>affectedVersion = "3.14"
     * <li>affectedVersion = "Big Ted"
     * <li>affectedVersion = 10350
     */
    AFFECTED_VERSION("affectedVersion", FieldTypeEnum.VERSION),

    /**
     * Issues that are assigned to a particular user.
     * <p>Examples:
     * <li>assignee = "John Smith"
     * <li>assignee = jsmith
     * <li>assignee WAS "John Smith"
     * <li>assignee WAS jsmith
     * <li>assignee = "bob@mycompany.com"
     */
    ASSIGNEE("assignee", FieldTypeEnum.USER),

    /**
     * Issues that belong to projects in a particular Category.
     * <p>Examples:
     * <li>category = "Alphabet Projects"
     */
    CATEGORY("category", FieldTypeEnum.CATEGORY),

    /**
     * Issues that have a CommentBean which contains particular text.
     * <p>Examples:
     * <li>comment ~ "My PC is quite old"
     * <li>comment ~ "\"My PC is quite old\""
     */
    COMMENT("comment", FieldTypeEnum.TEXT),

    /**
     * Issues that belong to a particular component(s) of a project.
     * <p>Examples:
     * <li>component in (Comp1, Comp2)
     * <li>component in (Comp1) and component in (Comp2)
     * <li>component = Comp1 and component = Comp2
     * <li>component = 20500
     */
    COMPONENT("component", FieldTypeEnum.COMPONENT),

    /**
     * Issues that were created on, before or after a particular date (or date range).
     * <p>Use one of the following formats:
     * <li>"yyyy/MM/dd HH:mm"</li>
     * <li>"yyyy-MM-dd HH:mm"</li>
     * <li>"yyyy/MM/dd"</li>
     * <li>"yyyy-MM-dd"</li>
     * <p>Alias <b>createdDate</b>.
     * <p>Examples:
     * <li>created < "2010/12/12"
     * <li>created <= "2010/12/13"
     * <li>created > "2010/12/12" and created < "2010/12/12 14:00"
     * <li>created > "-1d"
     * <li>created > "2011/01/01" and created < "2011/02/01"
     * <li>created > "2011/01/15" and created < "2011/01/16"
     */
    CREATED("created", FieldTypeEnum.DATE),

//	CUSTOM_FIELD("CustomFieldName", FieldTypeEnum.CUSTOM_TYPE),

    /**
     * Issues where the Description contains particular text.
     * <p>Examples:
     * <li>description ~ "Please see screenshot"
     * <li>description ~ "\"Please see screenshot\""
     */
    DESCRIPTION("description", FieldTypeEnum.TEXT),

    /**
     * Issues that were due on, before or after a particular date (or date range).
     * <p>Use one of the following formats:
     * <li>"yyyy/MM/dd"</li>
     * <li>"yyyy-MM-dd"</li>
     * <p>Alias <b>dueDate</b>.
     * <p>Examples:
     * <li>due < "2010/12/31"
     * <li>due <= "2011/01/01"
     * <li>due = "1d"
     * <li>due >= "2011/01/01" and due <= "2011/01/31"
     * <li>due = "2011/01/15"
     */
    DUE("due", FieldTypeEnum.DATE),

    /**
     * Issues where the Environment contains particular text.
     * <p>Examples:
     * <li>environment ~ "Third floor"
     * <li>environment ~ "\"Third floor\""
     */
    ENVIRONMENT("environment", FieldTypeEnum.TEXT),

    /**
     * <i>Only available if you are using GreenHopper 6.1.2 or later.</i>
     * <p>Issues that belong to a particular epic in GreenHopper.
     * <p>Examples:
     * <li>"epic link" = ANERDS-317
     * <li>"epic link" = Jupiter
     */
    EPIC_LINKS("epic link", FieldTypeEnum.CUSTOM_TYPE),

    /**
     * You can use a saved filter to narrow your search. You can search by filter name or
     * filter ID (i.e. the number that JIRA automatically allocates to a saved filter).
     * <p>Alias <b>request</b>, <b>savedFilter</b>, <b>searchRequest</b>.
     * <p>Examples:
     * <li>filter = "My Saved FilterBean" and assignee = jsmith
     * <li>filter = 12000 and assignee = jsmith
     */
    FILTER("filter", FieldTypeEnum.FILTER),

    /**
     * Issues that are assigned to a particular Fix VersionBean.
     * <p>Examples:
     * <li>fixVersion in ("3.14", "4.2")
     * <li>fixVersion = "Little Ted"
     * <li>fixVersion = 10001
     */
    FIX_VERSION("fixVersion", FieldTypeEnum.VERSION),

    /**
     * Issues with a particular IssueBean Key or IssueBean ID (i.e. the number that JIRA automatically allocates to an IssueBean).
     * <p>Alias <b>id</b>, <b>issue</b>, <b>key</b>.
     * <p>Examples:
     * <li>issueKey = ABC-123
     */
    ISSUE_KEY("issueKey", FieldTypeEnum.ISSUE),

    /**
     * Issues that were last viewed on, before or after a particular date (or date range).
     * <p>Use one of the following formats:
     * <li>"yyyy/MM/dd HH:mm"</li>
     * <li>"yyyy-MM-dd HH:mm"</li>
     * <li>"yyyy/MM/dd"</li>
     * <li>"yyyy-MM-dd"</li>
     * <p>Examples:
     * <li>lastViewed < "2010/12/12"
     * <li>lastViewed <= "2010/12/13"
     * <li>lastViewed > "2010/12/12" and created < "2010/12/12 14:00"
     * <li>lastViewed > "-1d"
     * <li>lastViewed > "2011/01/01" and created < "2011/02/01"
     * <li>lastViewed > "2011/01/15" and created < "2011/01/16"
     */
    LAST_VIEWED("lastViewed", FieldTypeEnum.DATE),

    /**
     * <i>Only available if IssueBean LevelBean Security has been enabled by your JIRA administrator.</i>
     * <p>Issues with a particular Security LevelBean.
     * <p>Examples:
     * <li>level in ("Really High", level1)
     * <li>level = 123
     */
    LEVEL("level", FieldTypeEnum.SECURITY_LEVEL),

    /**
     * <i>Only available if time-tracking has been enabled by your JIRA administrator.</i>
     * <p>Search for issues where the Original Estimate is set to a particular value (i.e. a number, not a date or date range).
     * <p>Alias <b>timeOriginalEstimate</b>
     * <p>Examples:
     * <li>originalEstimate = 1h
     * <li>originalEstimate > 2d
     */
    ORIGINAL_ESTIMATE("originalEstimate", FieldTypeEnum.DURATION),

    /**
     * <i>Only available if sub-tasks have been enabled by your JIRA administrator.</i>
     * <p>Search for all sub-tasks of a particular issue.
     * <p>Examples:
     * <li>parent = TEST-1234
     */
    PARENT("parent", FieldTypeEnum.ISSUE),

    /**
     * Issues with a particular PriorityBean.
     * <p>Examples:
     * <li>priority = High
     * <li>priority = 10000
     */
    PRIORITY("priority", FieldTypeEnum.PRIORITY),

    /**
     * Issues that belong to a particular ProjectBean.
     * <p>Examples:
     * <li>project = "ABC ProjectBean"
     * <li>project = "ABC"
     * <li>project = 1234
     */
    PROJECT("project", FieldTypeEnum.PROJECT),

    /**
     * <i>Only available if time-tracking has been enabled by your JIRA administrator.</i>
     * <p>Search for issues where the Remaining Estimate is set to a particular value (i.e. a number, not a date or date range).
     * <p>Alias <b>timeEstimate</b>
     * <p>Examples:
     * <li>remainingEstimate > 4h
     */
    REMAINING_ESTIMATE("remainingEstimate", FieldTypeEnum.DURATION),

    /**
     * Issues that were reported by (i.e. created by) a particular user.
     * <p>Examples:
     * <li>reporter = "Jill Jones"
     * <li>reporter = jjones
     * <li>reporter = "bob@mycompany.com"
     */
    REPORTER("reporter", FieldTypeEnum.USER),

    /**
     * Issues that have a particular ResolutionBean.
     * <p>Examples:
     * <li>resolution in ("Cannot Reproduce", "Won't Fix")
     * <li>resolution = 5
     * <li>resolution = unresolved
     */
    RESOLUTION("resolution", FieldTypeEnum.RESOLUTION),

    /**
     * Issues that were resolved on, before or after a particular date (or date range).
     * <p>Use one of the following formats:
     * <li>"yyyy/MM/dd HH:mm"</li>
     * <li>"yyyy-MM-dd HH:mm"</li>
     * <li>"yyyy/MM/dd"</li>
     * <li>"yyyy-MM-dd"</li>
     * <p>Alias <b>resolutionDate</b>
     * <p>Examples:
     * <li>resolved <= "2010/12/31"
     * <li>resolved < "2010/12/31 14:00"
     * <li>resolved <= "2011/01/01"
     * <li>resolved > "2011/01/01" and resolved < "2011/02/01"
     * <li>resolved > "2011/01/15" and resolved < "2011/01/16"
     * <li>resolved > -1h
     */
    RESOLVED("resolved", FieldTypeEnum.DATE),

    /**
     * <i>Only available if you are using GreenHopper.</i>
     * <p>Search for issues that are assigned to a particular sprint in GreenHopper.
     * <p>Examples:
     * <li>sprint = 999
     * <li>sprint = "February 1"
     * <li>sprint in ("February 1","February 2","February 3")
     * <li>sprint is not empty
     */
    SPRINT("sprint", FieldTypeEnum.NUMBER),

    /**
     * Issues that have a particular StatusBean.
     * <p>Examples:
     * <li>status = Open
     * <li>status = 1
     * <li>status WAS Open
     */
    STATUS("status", FieldTypeEnum.STATUS),

    /**
     * Issues where the Summary contains particular text.
     * <p>Examples:
     * <li>summary ~ "ErrorBean saving file"
     * <li>summary ~ "\"ErrorBean saving file\""
     */
    SUMMARY("summary", FieldTypeEnum.TEXT),

    /**
     * This is a "master-field" that allows you to search all text fields, i.e.:
     * <li>Summary</li>
     * <li>Description</li>
     * <li>Environment</li>
     * <li>CommentsBean</li>
     * <p>Examples:
     * <li>text ~ "Fred"
     * <li>text ~ Fred
     * <li>text ~ "\"full screen\""
     */
    TEXT("text", FieldTypeEnum.TEXT_MASTER),

    /**
     * Issues that have a particular IssueBean TypeBean.
     * <p>Alias <b>issueType</b>
     * <p>Examples:
     * <li>type = Bug
     * <li>issueType in (Bug,Improvement)
     * <li>issueType = 2
     */
    ISSUE_TYPE("issuetype", FieldTypeEnum.ISSUE_TYPE),

    /**
     * <i>Only available if time-tracking has been enabled by your JIRA administrator.</i>
     * <p>Search for issues where the Time Spent is set to a particular value (i.e. a number, not a date or date range).
     * <p>Examples:
     * <li>timeSpent > 5d
     */
    TIME_SPENT("timeSpent", FieldTypeEnum.DURATION),

    /**
     * Issues that were updated on, before or after a particular date (or date range).
     * <p>Use one of the following formats:
     * <li>"yyyy/MM/dd HH:mm"</li>
     * <li>"yyyy-MM-dd HH:mm"</li>
     * <li>"yyyy/MM/dd"</li>
     * <li>"yyyy-MM-dd"</li>
     * <p>Alias <b>updatedDate</b>
     * <p>Examples:
     * <li>updated < "2010/12/12"
     * <li>updated < "2010/12/13"
     * <li>updated < "2010/12/31 14:00"
     * <li>updated < "-2w"
     * <li>updated > "2011/01/15" and updated < "2011/01/16"
     * <li>updated > "20011/01/01" and updated < "2011/02/01"
     */
    UPDATED("updated", FieldTypeEnum.DATE),

    /**
     * Issues for which a particular user has voted.
     * <p>Examples:
     * <li>voter = "jsmith"
     */
    VOTER("voter", FieldTypeEnum.USER),

    /**
     * Issues with a specified number of votes.
     * <p>Examples:
     * <li>votes >= 12
     */
    VOTES("votes", FieldTypeEnum.NUMBER),

    /**
     * Issues that a particular user is watching.
     * <p>Examples:
     * <li>watcher = "jsmith"
     */
    WATCHER("watcher", FieldTypeEnum.USER),

    /**
     * Issues with a specified number of watchers.
     * <p>Examples:
     * <li>watchers > 3
     */
    WATCHERS("watchers", FieldTypeEnum.NUMBER),

    /**
     * <i>Only available if time-tracking has been enabled by your JIRA administrator.</i>
     * <p>Issues where the Work Ratio has a particular value.</p>
     * Work Ratio is calculated as follows: workRatio = timeSpent / originalEstimate) x 100
     * <p>Examples:
     * <li>workRatio > 75
     */
    WORK_RATIO("workRatio", FieldTypeEnum.NUMBER),

    /** <i>Avaiable Transitions for the IssueBean</i>
     *  <p>an IssueBean has several TransitionBean to which the status can change.</p>
     */
    TRANSITIONS("transitions", FieldTypeEnum.CUSTOM_TYPE),


    /** <i>Avaiable changelog for an IssueBean</i>
     */
    CHANGELOG("changelog", FieldTypeEnum.CUSTOM_TYPE),

    /** <i>Renders the Description Markup to HTML</i>
     */
    RENDEREDFIELDS("renderedFields", FieldTypeEnum.CUSTOM_TYPE),

    /**
     * <i>AttachmentBean Informations</i>
     */
    ATTACHMENT("attachment", FieldTypeEnum.CUSTOM_TYPE);

    /**
     * The name of the field.
     */
    private final String field;

    /**
     * The type of the field.
     */
    private final FieldTypeEnum type;

    /**
     * Instantiates a new field.
     *
     * @param field = name of the field
     * @param type  = type of the field
     */
    FieldEnum(String field, FieldTypeEnum type) {
        this.field = field;
        this.type = type;
    }

    /**
     * Gets the name of the field.
     *
     * @return the field name
     */
    public String getField() {
        return field;
    }

    /**
     * Gets the type of the field.
     *
     * @return the field type
     */
    public FieldTypeEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return getField();
    }
}
