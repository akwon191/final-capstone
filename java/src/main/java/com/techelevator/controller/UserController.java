package com.techelevator.controller;

import com.techelevator.model.User;
import com.techelevator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
;
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

}
