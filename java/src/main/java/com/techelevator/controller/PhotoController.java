package com.techelevator.controller;


import com.techelevator.dao.PhotoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/photos")
public class PhotoController {
    @Autowired
    private PhotoDao photoDao;
    //private PhotoService photoService;
     public PhotoController(PhotoDao photoDao){
         this.photoDao = photoDao;
     }
}
