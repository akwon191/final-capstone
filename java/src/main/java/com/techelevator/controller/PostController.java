package com.techelevator.controller;


import com.techelevator.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostDao postDao;
    //private Service photoService;
     public PostController(PostDao postDao){
         this.postDao = postDao;
     }
}
