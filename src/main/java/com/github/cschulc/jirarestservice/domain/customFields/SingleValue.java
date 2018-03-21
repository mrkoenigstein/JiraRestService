package com.github.cschulc.jirarestservice.domain.customFields;

public class SingleValue extends CustomFieldBase {

    private Value value;

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
