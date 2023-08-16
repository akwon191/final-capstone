package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.techelevator.service.NoThanksService;
import com.techelevator.model.NoThanks;

import java.util.List;
@RequestMapping("/no_thanks")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class NoThanksController {

    private final NoThanksService noThanksService;

    @Autowired
    public NoThanksController(NoThanksService noThanksService) {
        this.noThanksService = noThanksService;
    }

    @PostMapping("/{postId}/{userId}")
    public ResponseEntity<Void> createNoThanks(@PathVariable Long postId, @PathVariable Long userId) {
        noThanksService.createNoThanks(postId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{postId}/{userId}")
    public ResponseEntity<Void> deleteNoThanks(@PathVariable Long postId, @PathVariable Long userId) {
        noThanksService.deleteNoThanks(postId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Long>> getNoThanksByUserId(@PathVariable Long userId) {
        List<Long> postIds = noThanksService.getNoThanksByUserId(userId);
        return ResponseEntity.ok(postIds);
    }
}