package com.techelevator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.techelevator.model.Thanks;

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
    public List<Thanks> getAllThanks() {
        String sql = "SELECT user_id, post_id FROM thanks";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Thanks thanks = new Thanks();
            thanks.setUserId(rs.getLong("user_id"));
            thanks.setPostId(rs.getLong("post_id"));
            return thanks;
        });
    }
}