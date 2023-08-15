package com.techelevator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.techelevator.model.NoThanks;

import java.util.List;

@Repository
public class JdbcNoThanksDao implements NoThanksDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcNoThanksDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createNoThanks(Long postId, Long userId) {
        String sql = "INSERT INTO no_thanks (user_id, post_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, postId);
    }

    @Override
    public void deleteNoThanks(Long postId, Long userId) {
        String sql = "DELETE FROM no_thanks WHERE post_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, postId, userId);
    }

    @Override
    public List<NoThanks> getAllNoThanks() {
        String sql = "SELECT user_id, post_id FROM no_thanks";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            NoThanks noThanks = new NoThanks();
            noThanks.setUserId(rs.getLong("user_id"));
            noThanks.setPostId(rs.getLong("post_id"));
            return noThanks;
        });
    }
}
