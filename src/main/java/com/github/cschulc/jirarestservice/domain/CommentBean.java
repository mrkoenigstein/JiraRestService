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

import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.google.gson.annotations.Expose;

import java.util.Objects;


public class CommentBean {

    @Expose
    private UserBean author;
    @Expose
    private String body;
    @Expose
    private String created;
    @Expose
    private String id;
    @Expose
    private String self;
    @Expose
    private UserBean updateAuthor;
    @Expose
    private String updated;

    public UserBean getAuthor() {
        return author;
    }

    public void setAuthor(UserBean author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public UserBean getUpdateAuthor() {
        return updateAuthor;
    }

    public void setUpdateAuthor(UserBean updateAuthor) {
        this.updateAuthor = updateAuthor;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentBean)) return false;
        CommentBean that = (CommentBean) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(body, that.body) &&
                Objects.equals(created, that.created) &&
                Objects.equals(id, that.id) &&
                Objects.equals(self, that.self) &&
                Objects.equals(updateAuthor, that.updateAuthor) &&
                Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, body, created, id, self, updateAuthor, updated);
    }
}
