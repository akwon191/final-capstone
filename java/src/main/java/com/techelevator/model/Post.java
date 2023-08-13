package com.techelevator.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class Post {
    private int postId;
    private int userId;
    private String username;
    private int imgId;
    private Timestamp dateTime;
    private String caption;
    private int likeCount;
    private int dislikeCount;
    private int vibeCount;
    private List<Comment> comments;

    public Post() {

    }

    public Post( int postId, int userId, String username, int imgId, Timestamp dateTime, String caption, int likeCount, int dislikeCount, int vibeCount) {
        this.postId = postId;
        this.userId = userId;
        this.username = username;
        this.imgId = imgId;
        this.dateTime = dateTime;
        this.caption = caption;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.vibeCount = vibeCount;
        this.comments = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void addComment(Comment comment) {
    comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public int getVibeCount() {
        return vibeCount;
    }

    public void setVibeCount(int vibeCount) {
        this.vibeCount = vibeCount;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", dateTime=" + dateTime +
                ", caption='" + caption + '\'' +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                ", vibeCount=" + vibeCount +
                ", comments=" + comments +
                '}';
    }
}
