package com.techelevator.controller;

import com.techelevator.model.Post;
import com.techelevator.model.User;
import com.techelevator.service.ImageService;
import com.techelevator.service.PostService;
import com.techelevator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.List;

//@PreAuthorize("isAuthenticated()")
@RequestMapping("/posts")
@RestController
@CrossOrigin

public class PostController {
        @Autowired

        private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;

    }


    @GetMapping(path = "")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}