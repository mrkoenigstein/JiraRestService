package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Error {

    @Expose
    private List<String> errorMessages = new ArrayList<>();
    @Expose
    private Errors errors;

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
