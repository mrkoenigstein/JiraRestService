package com.github.cschulc.jirarestservice.domain.customFields;

import java.util.ArrayList;
import java.util.List;

public class MultiValue extends CustomFieldBase {

    private List<Value> values;

    public List<Value> getValues() {
        if(values == null){
            values = new ArrayList<>();
        }
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}
