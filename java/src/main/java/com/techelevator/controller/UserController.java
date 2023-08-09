package com.techelevator.controller;

import com.techelevator.exception.ResourceNotFoundException;
import com.techelevator.model.User;
import com.techelevator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
;
import javax.validation.Valid;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RequestMapping("/users")
@RestController
@CrossOrigin (origins="*")

public class UserController {
    @Autowired

    private UserService userService;

    public UserController(UserService userService){
               this.userService = userService;
    }

    @GetMapping(path = "")
    public List<User> listUsers() {
        return userService.findAll();
    }
    @GetMapping(path = "/{userId}")
    public User getUserById(@Valid @PathVariable int userId) throws ResourceNotFoundException {
        return userService.getUserById(userId);
    }
    @GetMapping(path = "/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestParam String username,
                                             @RequestParam String password,
                                             @RequestParam String role) {
        boolean created = userService.createUser(username, password, role);
        if (created) {
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
