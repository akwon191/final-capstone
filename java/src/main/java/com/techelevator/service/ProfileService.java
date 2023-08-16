package com.techelevator.service;


import com.techelevator.dao.JdbcProfileDao;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final JdbcProfileDao profileDao;

    @Autowired
    public ProfileService(JdbcProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public int createProfile(Profile profile) {
        return profileDao.createProfile(profile);
    }

    public Profile getProfileById(int userId) {
        return profileDao.getProfileById(userId);
    }

    public List<Profile> getFollowers(int userId) {
        return profileDao.getFollowers(userId);
    }
}

