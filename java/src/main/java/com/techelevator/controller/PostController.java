package com.techelevator.controller;


import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Image;
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

@PreAuthorize("isAuthenticated()")
@RequestMapping("/posts")
@RestController
@CrossOrigin

public class PostController {
        @Autowired

        private PostService postService;
        private ImageService imageService;
        private UserService userService;

    public PostController(PostService postService,ImageService imageService,UserService userService){
            this.imageService = imageService;
            this.postService = postService;
            this.userService = userService;
        }
    @GetMapping(path = "")
    public List<User> listUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping(path = "/{imageId}")
    public Image getImageDataById(@Valid @PathVariable long imageId) {
       // try {
            return imageService.getImageDataStringById(imageId);
      //  } catch (ResourceNotFoundException e) {
      //      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
     //   }
    }


}