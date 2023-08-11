package com.techelevator.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@PreAuthorize("isAuthenticated()")
@RequestMapping("/comment")
@RestController
@CrossOrigin

public class CommentController {
}
