package com.techelevator.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@PreAuthorize("isAuthenticated()")
@RequestMapping("/comment")
@RestController
@CrossOrigin(origins = "http://localhost:8080",
        methods = {RequestMethod.POST, RequestMethod.OPTIONS},
        allowedHeaders = {"Authorization", "Content-Type"},
        allowCredentials = "true")

public class CommentController {
}
