package com.techelevator.model;

import java.sql.Timestamp;

public class Comment {
    private int userId;
    private String commentText;
    private Timestamp dateTime;

    public Comment(int userId, String commentText, Timestamp dateTime) {
        this.userId = userId;
        this.commentText = commentText;
        this.dateTime = dateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}