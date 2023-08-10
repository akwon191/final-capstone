package com.techelevator.controller;

import com.techelevator.model.Image;
import com.techelevator.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping(path = "/upload")
    public ResponseEntity<?> uploadImage(@RequestBody Image image) {
        Image uploadedImage = imageService.uploadImage(image);
        if (uploadedImage != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Image uploaded successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Image upload failed.");
        }

    }


}