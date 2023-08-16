package com.techelevator.controller;



import com.techelevator.dao.FollowDao;
import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Profile;
import com.techelevator.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RequestMapping("/profiles")
@RestController
@CrossOrigin

public class ProfileController  {
    @Autowired
    private ProfileDao profileDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private FollowDao followDao;

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public Profile getMyProfile(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());

        Profile profile = (profileDao.getProfile(userId));
        profile.setPostCount(followDao.countPosts(userId));
        profile.setFollowerCount(followDao.countFollowers(userId));
        profile.setFollowingCount(followDao.countFollowing(userId));

        return profile;
    }

}




