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

package com.github.cschulc.jirarestservice.domain.avatar;

import com.github.cschulc.jirarestservice.domain.BaseBean;
import com.google.gson.annotations.Expose;

import java.util.Objects;

/**
 * Author: Christian Schulze (cschulc@outlook.com)
 * Date: 04.07.2018
 * Time: 10:24
 */
public class AvatarBean extends BaseBean {

    @Expose
    private String owner;

    @Expose
    private boolean isSystemAvatar;

    @Expose
    private boolean isSelected;

    @Expose
    private boolean isDeletable;

    @Expose
    private AvatarUrlsBean urls;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isSystemAvatar() {
        return isSystemAvatar;
    }

    public void setSystemAvatar(boolean systemAvatar) {
        isSystemAvatar = systemAvatar;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean selected) {
        isSelected = selected;
    }

    public AvatarUrlsBean getUrls() {
        return urls;
    }

    public void setUrls(AvatarUrlsBean urls) {
        this.urls = urls;
    }

    public boolean isDeletable() {
        return isDeletable;
    }

    public void setDeletable(boolean deletable) {
        isDeletable = deletable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AvatarBean that = (AvatarBean) o;
        return isSystemAvatar == that.isSystemAvatar &&
                isSelected == that.isSelected &&
                isDeletable == that.isDeletable &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(urls, that.urls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), owner, isSystemAvatar, isSelected, isDeletable, urls);
    }
}
