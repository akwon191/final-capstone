package com.techelevator.dao;


import com.techelevator.model.Image;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

@Component
public class JdbcImageDao implements ImageDao {


    //TO-DO - ERROR HANDLING FOR jdbc query

    private final JdbcTemplate jdbcTemplate;

    public JdbcImageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Image getImageDataStringById(long id) {
        String sql = "SELECT * FROM image_data WHERE image_data_id = ?";

        //Reduced complexity - queryForObject contains resultSet parameter to allow RowMapping and String conversion
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            byte[] imageData = resultSet.getBytes("image_data");
            // convert to String
            String imageDataString = Base64.getEncoder().encodeToString(imageData);
            Image newImg = new Image();
            newImg.setImageId(resultSet.getInt("image_data_id"));
            newImg.setImageName(resultSet.getString("image_name"));
            newImg.setImageData(imageDataString);
            return newImg;
        }, id);
    }


    public Image uploadImage(Image img) {

        Image newImg = null;
        String sql = "INSERT INTO image_data (image_name, image_data) VALUES (?, ?) RETURNING image_data_id";
        String inputString = img.getImageData();
        byte[] byteArray = inputString.getBytes();

        try {
            long imgId = jdbcTemplate.queryForObject(sql, int.class, img.getImageName(), byteArray);
            newImg = getImageDataStringById(imgId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
        return newImg;
    }



}



