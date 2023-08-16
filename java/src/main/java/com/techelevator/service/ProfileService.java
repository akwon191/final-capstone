package com.techelevator.service;


import com.techelevator.dao.JdbcProfileDao;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfileService {

    private final JdbcProfileDao profileDao;

    @Autowired
    public ProfileService(JdbcProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public Profile getProfileById(int userId) {
        return profileDao.getProfile(userId);
    }

}

