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

package com.github.cschulc.jirarestservice.domain.user;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserBean: Christian Schulze (cschulc@outlook.com)
 * Date: 21.06.2018
 * Time: 12:42
 */
public class CreateUserBean extends UserBean {

    @Expose
    private String password;

    @Expose
    private String notification;

    @Expose
    private List<String> applicationKeys = new ArrayList<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public List<String> getApplicationKeys() {
        return applicationKeys;
    }

    public void setApplicationKeys(List<String> applicationKeys) {
        this.applicationKeys = applicationKeys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserBean)) return false;
        if (!super.equals(o)) return false;
        CreateUserBean that = (CreateUserBean) o;
        return Objects.equals(password, that.password) &&
                Objects.equals(notification, that.notification) &&
                Objects.equals(applicationKeys, that.applicationKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), password, notification, applicationKeys);
    }
}
