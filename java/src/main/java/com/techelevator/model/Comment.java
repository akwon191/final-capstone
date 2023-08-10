package com.techelevator.model;
import java.sql.Timestamp;

public class Comment {

    private int commentId;
    private int postId;
    private int userId;
    private Timestamp dateTime;
    private String commentText;

    public Comment(int commentId, int postId, int userId, Timestamp dateTime, String commentText) {
        this.commentId= commentId;
        this.postId = postId;
        this.userId = userId;
        this.dateTime = dateTime;
        this.commentText = commentText;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}