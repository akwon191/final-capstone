package com.techelevator.service;

import com.techelevator.dao.ThanksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techelevator.model.Thanks;
import java.util.List;

@Service
public class ThanksService {

    private final ThanksDao thanksDao;

    @Autowired
    public ThanksService(ThanksDao thanksDao) {
        this.thanksDao = thanksDao;
    }

    public void createThanks(Long postId, Long userId) {
        thanksDao.createThanks(postId, userId);
    }

    public void deleteThanks(Long postId, Long userId) {
        thanksDao.deleteThanks(postId, userId);
    }

    public List<Long> getThanksByUserId(Long userId) {
        return thanksDao.getThanksByUserId(userId);
    }
}