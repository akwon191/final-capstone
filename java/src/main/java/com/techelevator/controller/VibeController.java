package com.techelevator.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.techelevator.model.Vibe;
import com.techelevator.service.VibeService;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RequestMapping("/images")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class VibeController {

    private final VibeService vibeService;

    @Autowired
    public VibeController(VibeService vibeService) {
        this.vibeService = vibeService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Long>> getVibesByUserId(@PathVariable Long userId) {
        List<Long> postIds = vibeService.getPostIdsByUserId(userId);
        return ResponseEntity.ok(postIds);
    }
}