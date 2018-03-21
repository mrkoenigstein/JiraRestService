package com.github.cschulc.jirarestservice.domain;

import com.google.gson.annotations.Expose;

public class User extends Base {

    @Expose
    private Boolean active;
    @Expose
    private AvatarUrls avatarUrls;
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

    public AvatarUrls getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(AvatarUrls avatarUrls) {
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

}
