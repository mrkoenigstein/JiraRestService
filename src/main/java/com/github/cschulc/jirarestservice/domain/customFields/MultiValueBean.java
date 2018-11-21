package com.github.cschulc.jirarestservice.domain.customFields;

import java.util.ArrayList;
import java.util.List;

public class MultiValueBean extends CustomFieldBaseBean {

    private List<ValueBean> values;

    public List<ValueBean> getValues() {
        if(values == null){
            values = new ArrayList<>();
        }
        return values;
    }

    public void setValues(List<ValueBean> values) {
        this.values = values;
    }
}
