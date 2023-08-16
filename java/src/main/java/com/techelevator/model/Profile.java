package com.techelevator.model;

import java.util.Objects;

public class Profile {

    private int userId;
    private String description;
    private String username;

    private int postCount;

    private int followerCount;

    private int followingCount;

    public Profile(int userId, String description, String username, int postCount, int followerCount, int followingCount) {
        this.userId = userId;
        this.description = description;
        this.username = username;
        this.postCount = postCount;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
    }

    public Profile() {

    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return userId == profile.userId && postCount == profile.postCount && followerCount == profile.followerCount && followingCount == profile.followingCount && Objects.equals(description, profile.description) && Objects.equals(username, profile.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, description, username, postCount, followerCount, followingCount);
    }
}
