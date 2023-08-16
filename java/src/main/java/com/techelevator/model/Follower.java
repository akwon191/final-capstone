package com.techelevator.model;

import java.util.Objects;

public class Follower {

    private int userId;
    private int followerId;

    public Follower(int userId, int followerId) {
        this.userId = userId;
        this.followerId = followerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follower follower = (Follower) o;
        return userId == follower.userId && followerId == follower.followerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, followerId);
    }
}
