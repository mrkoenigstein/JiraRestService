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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class AvatarUrlsBean {

    @SerializedName("16x16")
    @Expose
    private String format16x16;

    @SerializedName("24x24")
    @Expose
    private String format24x24;

    @SerializedName("32x32")
    @Expose
    private String format32x32;

    @SerializedName("48x48")
    @Expose
    private String format48x48;

    public String getFormat16x16() {
        return format16x16;
    }

    public void setFormat16x16(String format16x16) {
        this.format16x16 = format16x16;
    }

    public String getFormat24x24() {
        return format24x24;
    }

    public void setFormat24x24(String format24x24) {
        this.format24x24 = format24x24;
    }

    public String getFormat32x32() {
        return format32x32;
    }

    public void setFormat32x32(String format32x32) {
        this.format32x32 = format32x32;
    }

    public String getFormat48x48() {
        return format48x48;
    }

    public void setFormat48x48(String format48x48) {
        this.format48x48 = format48x48;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvatarUrlsBean)) return false;
        AvatarUrlsBean that = (AvatarUrlsBean) o;
        return Objects.equals(format16x16, that.format16x16) &&
                Objects.equals(format24x24, that.format24x24) &&
                Objects.equals(format32x32, that.format32x32) &&
                Objects.equals(format48x48, that.format48x48);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format16x16, format24x24, format32x32, format48x48);
    }
}
