package com.techelevator.controller;



import com.techelevator.dao.FollowDao;
import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


@PreAuthorize("isAuthenticated()")
@RequestMapping("/profile")
@RestController
@CrossOrigin

public class ProfileController  {
    @Autowired
    private ProfileDao profileDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private FollowDao followDao;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public Profile getMyProfile(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());

        Profile profile = (profileDao.getProfile(userId));
        profile.setPostCount(followDao.countPosts(userId));
        profile.setFollowerCount(followDao.countFollowers(userId));
        profile.setFollowingCount(followDao.countFollowing(userId));

        return profile;
    }

}




