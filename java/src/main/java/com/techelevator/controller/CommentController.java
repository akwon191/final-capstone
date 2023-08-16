package com.techelevator.controller;


import com.techelevator.model.Comment;
import com.techelevator.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;


@PreAuthorize("isAuthenticated()")
@RequestMapping("/comments")
@RestController
@CrossOrigin
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping(path = "/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable int postId) throws SQLException {
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping(path = "")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }
}





