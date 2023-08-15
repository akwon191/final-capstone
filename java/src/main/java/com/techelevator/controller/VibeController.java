package com.techelevator.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.model.Vibe;
import com.techelevator.service.VibeService;
import java.util.List;

@RestController
@RequestMapping("/vibes")
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