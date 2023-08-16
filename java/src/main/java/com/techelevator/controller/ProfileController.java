package com.techelevator.controller;



import com.techelevator.model.Profile;
import com.techelevator.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RequestMapping("/profiles")
@RestController
@CrossOrigin

public class ProfileController  {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("")
    public ResponseEntity<Integer> createProfile(@RequestBody Profile profile) {
        int generatedProfileId = profileService.createProfile(profile);
        return new ResponseEntity<>(generatedProfileId, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Profile> getProfileById(@PathVariable int userId) {
        Profile profile = profileService.getProfileById(userId);
        if (profile != null) {
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{userId}/followers")
    public ResponseEntity<List<Profile>> getFollowers(@PathVariable int userId) {
        List<Profile> followers = profileService.getFollowers(userId);
        return new ResponseEntity<>(followers, HttpStatus.OK);
    }
}




