package com.techelevator.controller;

import com.techelevator.model.Image;
import com.techelevator.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@PreAuthorize("isAuthenticated()")
@RequestMapping("/images")
@RestController
@CrossOrigin

public class ImageController {
    @Autowired

    private ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService = imageService;

    }

    @GetMapping(path = "/{imageId}")
    public Image getImageDataById(@Valid @PathVariable long imageId) {
        return imageService.getImageDataStringById(imageId);
    }


}