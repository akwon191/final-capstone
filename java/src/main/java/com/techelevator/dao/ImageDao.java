package com.techelevator.dao;

import com.techelevator.model.Image;
import com.techelevator.model.Post;

import java.util.List;

public interface ImageDao {

    Image getImageDataStringById(long id);
}
