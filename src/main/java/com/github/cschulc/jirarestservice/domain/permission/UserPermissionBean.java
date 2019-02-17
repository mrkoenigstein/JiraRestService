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

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import java.util.Objects;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 03.07.2018
 * Time: 12:54
 */
public class UserPermissionBean extends BaseBean {

    @Expose
    private String key;

    @Expose
    private String type;

    @Expose
    private boolean deprecatedKey;

    @Expose
    private String description;

    @Expose
    private boolean havePermission;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDeprecatedKey() {
        return deprecatedKey;
    }

    public void setDeprecatedKey(boolean deprecatedKey) {
        this.deprecatedKey = deprecatedKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHavePermission() {
        return havePermission;
    }

    public void setHavePermission(boolean havePermission) {
        this.havePermission = havePermission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPermissionBean)) return false;
        if (!super.equals(o)) return false;
        UserPermissionBean that = (UserPermissionBean) o;
        return deprecatedKey == that.deprecatedKey &&
                havePermission == that.havePermission &&
                Objects.equals(key, that.key) &&
                Objects.equals(type, that.type) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, type, deprecatedKey, description, havePermission);
    }
}
