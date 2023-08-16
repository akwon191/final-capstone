package com.techelevator.dao;

import com.techelevator.model.Thanks;

import java.util.List;

public interface ThanksDao {

    void createThanks(Long postId, Long userId);

    void deleteThanks(Long postId, Long userId);

    List<Long> getThanksByUserId(Long userId);
}