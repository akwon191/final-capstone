package com.techelevator.dao;

public interface FollowDao {
    int countFollowers(int userId);

    int countFollowing(int userId);

    int countPosts(int userId);
}
