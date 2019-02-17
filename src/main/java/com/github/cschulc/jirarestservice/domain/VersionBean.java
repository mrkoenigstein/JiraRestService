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

package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class VersionBean extends BaseBean {

    @Expose
    private Boolean archived;
    @Expose
    private String description;
    @Expose
    private String releaseDate;
    @Expose
    private Boolean released;
    @Expose
    private String userStartDate;
    @Expose
    private String userReleaseDate;
    @Expose
    private Integer projectId;

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getReleased() {
        return released;
    }

    public void setReleased(Boolean released) {
        this.released = released;
    }

    public String getUserStartDate() {
        return userStartDate;
    }

    public void setUserStartDate(String userStartDate) {
        this.userStartDate = userStartDate;
    }

    public String getUserReleaseDate() {
        return userReleaseDate;
    }

    public void setUserReleaseDate(String userReleaseDate) {
        this.userReleaseDate = userReleaseDate;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VersionBean)) return false;
        if (!super.equals(o)) return false;
        VersionBean that = (VersionBean) o;
        return Objects.equals(archived, that.archived) &&
                Objects.equals(description, that.description) &&
                Objects.equals(releaseDate, that.releaseDate) &&
                Objects.equals(released, that.released) &&
                Objects.equals(userStartDate, that.userStartDate) &&
                Objects.equals(userReleaseDate, that.userReleaseDate) &&
                Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), archived, description, releaseDate, released, userStartDate, userReleaseDate, projectId);
    }
}
