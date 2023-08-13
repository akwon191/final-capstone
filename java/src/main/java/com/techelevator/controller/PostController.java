package com.techelevator.controller;

import com.techelevator.model.Post;
import com.techelevator.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@PreAuthorize("isAuthenticated()")
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

    @PostMapping(path = "")
    public ResponseEntity<?> addPost(@RequestBody Post post) {
        try {
            int postId = postService.addPost(post);
            return ResponseEntity.ok().body("Post added successfully with ID: " + postId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding post: " + e.getMessage());
        }
    }
}