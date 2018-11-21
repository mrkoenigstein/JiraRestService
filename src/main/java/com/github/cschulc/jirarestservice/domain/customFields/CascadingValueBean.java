package com.github.cschulc.jirarestservice.domain.customFields;

public class CascadingValueBean extends CustomFieldBaseBean {

    private ValueBean value;

    public ValueBean getValue() {
        return value;
    }

    public void setValue(ValueBean value) {
        this.value = value;
    }
}
