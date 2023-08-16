package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcProfileDao implements ProfileDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

   


    @Override
    public Profile getProfileById(int userId) {
        String sql = "SELECT user_id, description, username FROM profiles WHERE user_id = ?";
        RowMapper<Profile> rowMapper = (resultSet, rowNum) -> mapRowToProfile((SqlRowSet) resultSet);
        return jdbcTemplate.queryForObject(sql, rowMapper, userId);
    }

    @Override
    public List<Profile> getFollowers(int userId) {
        String sql = "SELECT p.user_id, p.description, p.username FROM profiles p " +
                "JOIN followers f ON p.user_id = f.follower_id " +
                "WHERE f.followed_id = ?";
        RowMapper<Profile> rowMapper = (resultSet, rowNum) -> mapRowToProfile((SqlRowSet) resultSet);
        return jdbcTemplate.query(sql, rowMapper, userId);
    }



    public Profile mapRowToProfile(SqlRowSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");
        String description = resultSet.getString("description");
        String username = resultSet.getString("username");

        return new Profile(userId, description, username);
    }
}