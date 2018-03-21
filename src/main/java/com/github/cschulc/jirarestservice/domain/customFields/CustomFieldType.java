package com.github.cschulc.jirarestservice.domain.customFields;

public enum CustomFieldType {

    // String Value Custom Fields
    URL("com.atlassian.jira.plugin.system.customfieldtypes:url", false),
    DATE("com.atlassian.jira.plugin.system.customfieldtypes:datepicker", false),
    DATETIME("com.atlassian.jira.plugin.system.customfieldtypes:datetime", false),
    TEXT("com.atlassian.jira.plugin.system.customfieldtypes:textfield", false),
    TEXTAREA("com.atlassian.jira.plugin.system.customfieldtypes:textarea", false),
    FLOAT("com.atlassian.jira.plugin.system.customfieldtypes:float", false),

    // Single Value Custom Fields
    SELECT("com.atlassian.jira.plugin.system.customfieldtypes:select", true),
    RADIO("com.atlassian.jira.plugin.system.customfieldtypes:radiobuttons", true),

    // Multi Value Custom Fields
    MULTISELECT("com.atlassian.jira.plugin.system.customfieldtypes:multiselect", true),
    CHECKBOX("com.atlassian.jira.plugin.system.customfieldtypes:multicheckboxes", true),
    LABELS("com.atlassian.jira.plugin.system.customfieldtypes:labels", false),
    CASCADING("com.atlassian.jira.plugin.system.customfieldtypes:cascadingselect", true),
    USER("com.atlassian.jira.plugin.system.customfieldtypes:userpicker", false),
    MULTIUSER("com.atlassian.jira.plugin.system.customfieldtypes:multiuserpicker", false),
    PROJECT("com.atlassian.jira.plugin.system.customfieldtypes:project", false),
    VERSION("com.atlassian.jira.plugin.system.customfieldtypes:version", false),
    MULTIVERSION("com.atlassian.jira.plugin.system.customfieldtypes:multiversion", false),
    GROUP("com.atlassian.jira.plugin.system.customfieldtypes:grouppicker", false),
    MULTIGROUP("com.atlassian.jira.plugin.system.customfieldtypes:multigrouppicker", false),
    UNKNOWN("unknown.custom.field.type", false);

    CustomFieldType(String jiraName, boolean hasAllowedValues) {
        this.jiraName = jiraName;
        this.hasAllowedValues = hasAllowedValues;
    }

    private String jiraName;

    private boolean hasAllowedValues;

    public String getJiraName() {
        return jiraName;
    }

    public boolean isHasAllowedValues() {
        return hasAllowedValues;
    }
}
