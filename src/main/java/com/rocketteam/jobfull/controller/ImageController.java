package com.rocketteam.jobfull.controller;


import com.rocketteam.jobfull.model.Image;
import com.rocketteam.jobfull.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    //    When making a POST Request, use 'multipartImage' as a key, 'file' as a type and the image as the value
    @PostMapping
    Image uploadImage(@RequestParam MultipartFile multipartImage) throws IOException {
        return imageService.save(multipartImage);
    }

    @GetMapping(value = "/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    Resource downloadImage(@PathVariable Long imageId) {
        byte[] image = imageService.findById(imageId)
                .getContent();

        return new ByteArrayResource(image);
    }

    @PatchMapping(value = "/{imageId}")
    Image updateImage(@PathVariable Long imageId, @RequestBody Image image) {
        return imageService.updateImage(imageId, image);
    }

}