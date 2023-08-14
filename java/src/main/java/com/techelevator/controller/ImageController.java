package com.techelevator.controller;

import com.techelevator.model.Image;
import com.techelevator.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@CrossOrigin(origins = "http://localhost:8080")

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
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
            Image uploadedImage = imageService.uploadImage(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(uploadedImage);

    }
}