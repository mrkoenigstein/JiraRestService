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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RenderedFieldsBean {

    @Expose
    private String aggregatetimeestimate;
    @Expose
    private String aggregatetimeoriginalestimate;
    @Expose
    private TimeTrackingBean timetracking;
    @Expose
    private String environment;
    @Expose
    private String created;
    @Expose
    private String updated;
    @Expose
    private String description;
    @Expose
    private String timeestimate;
    @Expose
    private String duedate;
    @Expose
    private String lastViewed;
    @Expose
    private List<AttachmentBean> attachment = new ArrayList<>();
    @Expose
    private CommentsBean comment;
    @Expose
    private String timeoriginalestimate;
    @Expose
    private Object timespent;
    @Expose
    private WorklogBean worklog;
    @Expose
    private Object aggregatetimespent;

    public String getAggregatetimeestimate() {
        return aggregatetimeestimate;
    }

    public void setAggregatetimeestimate(String aggregatetimeestimate) {
        this.aggregatetimeestimate = aggregatetimeestimate;
    }

    public String getAggregatetimeoriginalestimate() {
        return aggregatetimeoriginalestimate;
    }

    public void setAggregatetimeoriginalestimate(String aggregatetimeoriginalestimate) {
        this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
    }

    public TimeTrackingBean getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(TimeTrackingBean timetracking) {
        this.timetracking = timetracking;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeestimate() {
        return timeestimate;
    }

    public void setTimeestimate(String timeestimate) {
        this.timeestimate = timeestimate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getLastViewed() {
        return lastViewed;
    }

    public void setLastViewed(String lastViewed) {
        this.lastViewed = lastViewed;
    }

    public List<AttachmentBean> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<AttachmentBean> attachment) {
        this.attachment = attachment;
    }

    public CommentsBean getComment() {
        return comment;
    }

    public void setComment(CommentsBean comment) {
        this.comment = comment;
    }

    public String getTimeoriginalestimate() {
        return timeoriginalestimate;
    }

    public void setTimeoriginalestimate(String timeoriginalestimate) {
        this.timeoriginalestimate = timeoriginalestimate;
    }

    public Object getTimespent() {
        return timespent;
    }

    public void setTimespent(Object timespent) {
        this.timespent = timespent;
    }

    public WorklogBean getWorklog() {
        return worklog;
    }

    public void setWorklog(WorklogBean worklog) {
        this.worklog = worklog;
    }

    public Object getAggregatetimespent() {
        return aggregatetimespent;
    }

    public void setAggregatetimespent(Object aggregatetimespent) {
        this.aggregatetimespent = aggregatetimespent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RenderedFieldsBean)) return false;
        RenderedFieldsBean that = (RenderedFieldsBean) o;
        return Objects.equals(aggregatetimeestimate, that.aggregatetimeestimate) &&
                Objects.equals(aggregatetimeoriginalestimate, that.aggregatetimeoriginalestimate) &&
                Objects.equals(timetracking, that.timetracking) &&
                Objects.equals(environment, that.environment) &&
                Objects.equals(created, that.created) &&
                Objects.equals(updated, that.updated) &&
                Objects.equals(description, that.description) &&
                Objects.equals(timeestimate, that.timeestimate) &&
                Objects.equals(duedate, that.duedate) &&
                Objects.equals(lastViewed, that.lastViewed) &&
                Objects.equals(attachment, that.attachment) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(timeoriginalestimate, that.timeoriginalestimate) &&
                Objects.equals(timespent, that.timespent) &&
                Objects.equals(worklog, that.worklog) &&
                Objects.equals(aggregatetimespent, that.aggregatetimespent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aggregatetimeestimate, aggregatetimeoriginalestimate, timetracking, environment, created, updated, description, timeestimate, duedate, lastViewed, attachment, comment, timeoriginalestimate, timespent, worklog, aggregatetimespent);
    }
}
