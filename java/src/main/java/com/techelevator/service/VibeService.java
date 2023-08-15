package com.techelevator.service;

import com.techelevator.dao.VibeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VibeService {

    private final VibeDao vibeDao;

    @Autowired
    public VibeService(VibeDao vibeDAO) {
        this.vibeDao = vibeDAO;
    }

    public List<Long> getPostIdsByUserId(Long userId) {
        return vibeDao.getPostIdsByUserId(userId);
    }
}