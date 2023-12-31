package com.techelevator.dao;

import com.techelevator.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageDao {

    Image getImageDataStringById(long id);

    Image uploadImageNew(MultipartFile file);

}
