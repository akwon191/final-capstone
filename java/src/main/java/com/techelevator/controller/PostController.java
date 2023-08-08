package com.techelevator.controller;


import com.techelevator.dao.PostDao;
import com.techelevator.model.Post;
import com.techelevator.service.ImageService;
import com.techelevator.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RequestMapping("/posts")
@RestController
@CrossOrigin

public class PostController {
    @Autowired

        private PostService postService;
        private ImageService imageService;

        public PostController(PostService postService,ImageService imageService){
            this.imageService = imageService;
            this.postService = postService;
        }

    @GetMapping(path = "")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}