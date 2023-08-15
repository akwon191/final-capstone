package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcVibeDao implements VibeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcVibeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Long> getPostIdsByUserId(Long userId) {
        String sql = "SELECT post_id FROM vibes WHERE user_id = ?";
        return jdbcTemplate.queryForList(sql, Long.class, userId);
    }
}