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

import com.github.cschulc.jirarestservice.domain.avatar.AvatarUrlsBean;
import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import java.util.Objects;

public class UserBean extends BaseBean {

    @Expose
    private Boolean active;
    @Expose
    private AvatarUrlsBean avatarUrls;
    @Expose
    private String displayName;
    @Expose
    private String emailAddress;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public AvatarUrlsBean getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(AvatarUrlsBean avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBean)) return false;
        if (!super.equals(o)) return false;
        UserBean userBean = (UserBean) o;
        return Objects.equals(active, userBean.active) &&
                Objects.equals(avatarUrls, userBean.avatarUrls) &&
                Objects.equals(displayName, userBean.displayName) &&
                Objects.equals(emailAddress, userBean.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), active, avatarUrls, displayName, emailAddress);
    }
}
