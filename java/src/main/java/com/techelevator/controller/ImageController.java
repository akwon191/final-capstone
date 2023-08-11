package com.techelevator.controller;

import com.techelevator.model.Image;
import com.techelevator.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;


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

    @PostMapping (path = "/upload")
    public Image uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        //try {
            Image imageEntity = new Image();
            imageEntity.setImageName(file.getOriginalFilename());
            String imageDataString = Base64.getEncoder().encodeToString(file.getBytes());
            imageEntity.setImageData(imageDataString);
            Image uploadedImage = imageService.uploadImage(imageEntity);
            return uploadedImage;
        //} catch (Exception e) {
           // return "Image upload failed: " + e.getMessage();
        //}
    }


}