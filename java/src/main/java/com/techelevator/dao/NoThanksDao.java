package com.techelevator.dao;

import com.techelevator.model.NoThanks;
import java.util.List;

public interface NoThanksDao {

    void createNoThanks(Long postId, Long userId);

    void deleteNoThanks(Long postId, Long userId);

    List<Long> getNoThanksByUserId(Long userId);
}