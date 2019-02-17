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

package com.github.cschulc.jirarestservice.domain.system;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class ConfigurationBean {

    @Expose
    private boolean votingEnabled;
    @Expose
    private boolean watchingEnabled;
    @Expose
    private boolean unassignedIssuesAllowed;
    @Expose
    private boolean subTasksEnabled;
    @Expose
    private boolean issueLinkingEnabled;
    @Expose
    private boolean timeTrackingEnabled;
    @Expose
    private boolean attachmentsEnabled;
    @Expose
    private TimeTrackingConfigurationBean timeTrackingConfiguration;

    public boolean isVotingEnabled() {
        return votingEnabled;
    }

    public void setVotingEnabled(boolean votingEnabled) {
        this.votingEnabled = votingEnabled;
    }

    public boolean isWatchingEnabled() {
        return watchingEnabled;
    }

    public void setWatchingEnabled(boolean watchingEnabled) {
        this.watchingEnabled = watchingEnabled;
    }

    public boolean isUnassignedIssuesAllowed() {
        return unassignedIssuesAllowed;
    }

    public void setUnassignedIssuesAllowed(boolean unassignedIssuesAllowed) {
        this.unassignedIssuesAllowed = unassignedIssuesAllowed;
    }

    public boolean isSubTasksEnabled() {
        return subTasksEnabled;
    }

    public void setSubTasksEnabled(boolean subTasksEnabled) {
        this.subTasksEnabled = subTasksEnabled;
    }

    public boolean issueLinkingEnabled() {
        return issueLinkingEnabled;
    }

    public void setIssueLinkingEnabled(boolean issueLinkingEnabled) {
        this.issueLinkingEnabled = issueLinkingEnabled;
    }

    public boolean isTimeTrackingEnabled() {
        return timeTrackingEnabled;
    }

    public void setTimeTrackingEnabled(boolean timeTrackingEnabled) {
        this.timeTrackingEnabled = timeTrackingEnabled;
    }

    public boolean isAttachmentsEnabled() {
        return attachmentsEnabled;
    }

    public void setAttachmentsEnabled(boolean attachmentsEnabled) {
        this.attachmentsEnabled = attachmentsEnabled;
    }

    public TimeTrackingConfigurationBean getTimeTrackingConfiguration() {
        return timeTrackingConfiguration;
    }

    public void setTimeTrackingConfiguration(TimeTrackingConfigurationBean timeTrackingConfiguration) {
        this.timeTrackingConfiguration = timeTrackingConfiguration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConfigurationBean)) return false;
        ConfigurationBean that = (ConfigurationBean) o;
        return votingEnabled == that.votingEnabled &&
                watchingEnabled == that.watchingEnabled &&
                unassignedIssuesAllowed == that.unassignedIssuesAllowed &&
                subTasksEnabled == that.subTasksEnabled &&
                issueLinkingEnabled == that.issueLinkingEnabled &&
                timeTrackingEnabled == that.timeTrackingEnabled &&
                attachmentsEnabled == that.attachmentsEnabled &&
                Objects.equals(timeTrackingConfiguration, that.timeTrackingConfiguration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votingEnabled, watchingEnabled, unassignedIssuesAllowed, subTasksEnabled, issueLinkingEnabled, timeTrackingEnabled, attachmentsEnabled, timeTrackingConfiguration);
    }
}
