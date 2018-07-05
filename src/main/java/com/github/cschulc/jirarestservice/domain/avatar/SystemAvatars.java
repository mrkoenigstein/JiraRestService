package com.github.cschulc.jirarestservice.domain.avatar;

import com.github.cschulc.jirarestservice.domain.BaseJson;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 04.07.2018
 * Time: 10:27
 */
public class SystemAvatars extends BaseJson {

    @Expose
    private List<Avatar> system = new ArrayList<>();

    public List<Avatar> getSystem() {
        return system;
    }

    public void setSystem(List<Avatar> system) {
        this.system = system;
    }
}
