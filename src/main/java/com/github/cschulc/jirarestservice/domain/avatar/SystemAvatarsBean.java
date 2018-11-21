package com.github.cschulc.jirarestservice.domain.avatar;

import com.github.cschulc.jirarestservice.domain.BaseJsonBean;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 04.07.2018
 * Time: 10:27
 */
public class SystemAvatarsBean extends BaseJsonBean {

    @Expose
    private List<AvatarBean> system = new ArrayList<>();

    public List<AvatarBean> getSystem() {
        return system;
    }

    public void setSystem(List<AvatarBean> system) {
        this.system = system;
    }
}
