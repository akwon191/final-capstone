package com.techelevator.dao;

import com.techelevator.model.Image;

public interface ImageDao {

    Image getImageDataStringById(long id);
     Image uploadImage(Image  img);
}
