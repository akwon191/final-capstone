package com.techelevator.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


    @Component
    public class JdbcFollowDAO implements FollowDao {

        private JdbcTemplate jdbcTemplate;

        public JdbcFollowDAO(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }
        @Override
        public int countFollowers( int userId) {
            String sqlCountFollowers = "SELECT COUNT(*) FROM following WHERE user_id_following = ?";
            Integer followers = jdbcTemplate.queryForObject(sqlCountFollowers, Integer.class, userId);
            return followers;
        }

        @Override
        public int countFollowing( int userId) {
            String sqlCountFollowing = "SELECT COUNT(*) FROM following WHERE user_id_follower = ?";
            Integer following = jdbcTemplate.queryForObject(sqlCountFollowing, Integer.class, userId);
            return following;
        }

        @Override
        public int countPosts(int userId) {
            String sqlCountPosts = "SELECT COUNT(*) FROM posts WHERE user_id = ?";
            Integer numPosts = jdbcTemplate.queryForObject(sqlCountPosts, Integer.class, userId);
            return numPosts;
        }
    }
