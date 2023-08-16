package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.techelevator.service.ThanksService;
import java.util.List;

@RequestMapping("/thanks")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ThanksController {

    private final ThanksService thanksService;

    @Autowired
    public ThanksController(ThanksService thanksService) {
        this.thanksService = thanksService;
    }

    @PostMapping("/{postId}/{userId}")
    public ResponseEntity<Void> createThanks(@PathVariable Long postId, @PathVariable Long userId) {
        thanksService.createThanks(postId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{postId}/{userId}")
    public ResponseEntity<Void> deleteThanks(@PathVariable Long postId, @PathVariable Long userId) {
        thanksService.deleteThanks(postId, userId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<Long>> getVibesByUserId(@PathVariable Long userId) {
        List<Long> postIds = thanksService.getThanksByUserId(userId);
        return ResponseEntity.ok(postIds);
    }
}