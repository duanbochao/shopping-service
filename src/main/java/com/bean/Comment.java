package com.bean;

import java.sql.Timestamp;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/9 9:28
 */
public class Comment {

    private Integer id;
    private String username;
    private String commentContent;
    private Timestamp commentDate;
    private boolean enabled;
    private String commetType;

    public String getCommetType() {
        return commetType;
    }

    public void setCommetType(String commetType) {
        this.commetType = commetType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
