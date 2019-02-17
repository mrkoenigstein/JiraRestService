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

package com.github.cschulc.jirarestservice.domain.permission;

import com.github.cschulc.jirarestservice.domain.BaseJsonBean;
import com.github.cschulc.jirarestservice.domain.project.ProjectRoleBean;
import com.google.gson.annotations.Expose;

import java.util.Objects;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 12:49
 */
public class HolderBean extends BaseJsonBean {

    @Expose
    private String type;

    @Expose
    private String parameter;

    @Expose
    private String expand;

    @Expose
    private ProjectRoleBean projectRole;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public ProjectRoleBean getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(ProjectRoleBean projectRole) {
        this.projectRole = projectRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HolderBean)) return false;
        HolderBean that = (HolderBean) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(parameter, that.parameter) &&
                Objects.equals(expand, that.expand) &&
                Objects.equals(projectRole, that.projectRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, parameter, expand, projectRole);
    }
}
