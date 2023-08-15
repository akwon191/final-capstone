package com.techelevator.dao;


import com.techelevator.model.Image;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@Component
public class JdbcImageDao implements ImageDao {

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

    public Image uploadImageNew(MultipartFile file) {
        Image newImg = null;
        String sql = "INSERT INTO image_data (image_name, image_data) VALUES (?, ?) RETURNING image_data_id";

        try {
                long imgId = jdbcTemplate.queryForObject(sql, int.class, file.getOriginalFilename(), file.getBytes());
                newImg = getImageDataStringById(imgId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newImg;
    }
}



