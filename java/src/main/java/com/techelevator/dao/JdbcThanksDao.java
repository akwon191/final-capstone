package com.techelevator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class JdbcThanksDao implements ThanksDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcThanksDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createThanks(Long postId, Long userId) {
        String sql = "INSERT INTO thanks (user_id, post_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, postId);
    }

    @Override
    public void deleteThanks(Long postId, Long userId) {
        String sql = "DELETE FROM thanks WHERE post_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, postId, userId);
    }

    @Override
    public List<Long> getThanksByUserId(Long userId) {
        String sql = "SELECT post_id FROM thanks WHERE user_id = ?";
        return jdbcTemplate.queryForList(sql, Long.class, userId);
    }
}