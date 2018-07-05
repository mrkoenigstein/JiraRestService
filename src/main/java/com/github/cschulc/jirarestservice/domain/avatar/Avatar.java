package com.github.cschulc.jirarestservice.domain.avatar;

import com.github.cschulc.jirarestservice.domain.Base;
import com.google.gson.annotations.Expose;

/**
 * User: Christian Schulze (cschulc@outlook.com)
 * Date: 04.07.2018
 * Time: 10:24
 */
public class Avatar extends Base {

    @Expose
    private String owner;

    @Expose
    private boolean isSystemAvatar;

    @Expose
    private boolean isSelected;

    @Expose
    private boolean isDeletable;

    @Expose
    private boolean selected;

    @Expose
    private AvatarUrls urls;

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

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public AvatarUrls getUrls() {
        return urls;
    }

    public void setUrls(AvatarUrls urls) {
        this.urls = urls;
    }

    public boolean isDeletable() {
        return isDeletable;
    }

    public void setDeletable(boolean deletable) {
        isDeletable = deletable;
    }
}
