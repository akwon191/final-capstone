package com.techelevator.dao;

import com.techelevator.model.Profile;

import java.util.List;

public interface ProfileDao {
     int createProfile(Profile profile);

     Profile getProfileById(int userId);

     List<Profile> getFollowers(int userId);
}
