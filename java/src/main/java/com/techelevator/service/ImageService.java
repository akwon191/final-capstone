package com.techelevator.service;

import com.techelevator.dao.JdbcImageDao;
import com.techelevator.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final JdbcImageDao imageDao;

    @Autowired
    public ImageService(JdbcImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public Image getImageDataStringById(long id) {
        return imageDao.getImageDataStringById(id);
    }
}