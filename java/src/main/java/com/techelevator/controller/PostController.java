package com.techelevator.controller;

import com.techelevator.model.Post;
import com.techelevator.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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