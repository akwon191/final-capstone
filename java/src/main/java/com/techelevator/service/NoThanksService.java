package com.techelevator.service;

import com.techelevator.dao.NoThanksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techelevator.model.NoThanks;

import java.util.List;
@Service
public class NoThanksService {

    private final NoThanksDao noThanksDao;

    @Autowired
    public NoThanksService(NoThanksDao noThanksDao) {
        this.noThanksDao = noThanksDao;
    }

    public void createNoThanks(Long postId, Long userId) {
        noThanksDao.createNoThanks(postId, userId);
    }

    public void deleteNoThanks(Long postId, Long userId) {
        noThanksDao.deleteNoThanks(postId, userId);
    }

    public List<Long> getNoThanksByUserId(Long userId) {
        return noThanksDao.getNoThanksByUserId(userId);
    }
}