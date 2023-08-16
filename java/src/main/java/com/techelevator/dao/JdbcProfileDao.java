package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;



@Component
public class JdbcProfileDao implements ProfileDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Profile getProfile(int userId) {

        String sqlGetProfile = "SELECT * FROM profiles p JOIN users ON users.user_id = p.user_id WHERE p.user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetProfile, userId);
        results.next();
        Profile theProfile = mapRowToProfile(results);

        return theProfile;
    }



    private Profile mapRowToProfile(SqlRowSet results) {
        Profile theProfile = new Profile();
        theProfile.setUserId(results.getInt("user_id"));
        theProfile.setUsername(results.getString("username"));
        theProfile.setDescription(results.getString("description"));

        return theProfile;
    }
}