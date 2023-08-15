package com.techelevator.dao;

import java.util.List;
import com.techelevator.model.Vibe;
public interface VibeDao {

    List<Long> getPostIdsByUserId(Long userId);

    void createVibe(Long postId, Long userId);

    void deleteVibe(Long postId, Long userId);
}