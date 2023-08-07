package com.techelevator.model;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Objects;

public class Post {
    private int postId;


    private int userId;
    @NotEmpty
    private String imgUrl;

    private Date dateTime;

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", imgUrl='" + imgUrl + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post photo = (Post) o;
        return postId == photo.postId && userId == photo.userId && Objects.equals(imgUrl, photo.imgUrl) && Objects.equals(dateTime, photo.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, userId, imgUrl, dateTime);
    }

    public void setPostId(int postId) {
        this.postId = postId;

    }
}
