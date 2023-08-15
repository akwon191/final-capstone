package com.techelevator.dao;

import java.util.List;

public interface VibeDao {

    List<Long> getPostIdsByUserId(Long userId);
}