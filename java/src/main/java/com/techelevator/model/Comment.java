package com.techelevator.model;
import java.sql.Timestamp;
import java.util.Objects;

public class Comment {

    private int commentId;
    private int postId;
    private int userId;
    private String username;
    private Timestamp dateTime;
    private String commentText;


    public Comment(int commentId, int postId, int userId, String username, Timestamp dateTime, String commentText) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return commentId == comment.commentId && postId == comment.postId && userId == comment.userId && Objects.equals(username, comment.username) && Objects.equals(dateTime, comment.dateTime) && Objects.equals(commentText, comment.commentText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, userId, username, dateTime, commentText);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", userId=" + userId +
                ", dateTime=" + dateTime +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}