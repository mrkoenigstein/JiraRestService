package com.github.cschulc.jirarestservice.domain.update;

import com.google.gson.annotations.Expose;

public class FieldOperationBean {

    @Expose
    private String operation;
    @Expose
    private Object value;

    public FieldOperationBean(String operation, Object value)
    {
        this.operation = operation;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
