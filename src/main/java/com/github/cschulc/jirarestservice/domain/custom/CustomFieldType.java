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

package com.github.cschulc.jirarestservice.domain.custom;

public enum CustomFieldType {

    // String ValueBean Custom FieldsBean
    URL("com.atlassian.jira.plugin.system.customfieldtypes:url", false),
    DATE("com.atlassian.jira.plugin.system.customfieldtypes:datepicker", false),
    DATETIME("com.atlassian.jira.plugin.system.customfieldtypes:datetime", false),
    TEXT("com.atlassian.jira.plugin.system.customfieldtypes:textfield", false),
    TEXTAREA("com.atlassian.jira.plugin.system.customfieldtypes:textarea", false),
    FLOAT("com.atlassian.jira.plugin.system.customfieldtypes:float", false),

    // Single ValueBean Custom FieldsBean
    SELECT("com.atlassian.jira.plugin.system.customfieldtypes:select", true),
    RADIO("com.atlassian.jira.plugin.system.customfieldtypes:radiobuttons", true),

    // Multi ValueBean Custom FieldsBean
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
