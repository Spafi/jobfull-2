package com.rocketteam.jobfull.service;


import com.rocketteam.jobfull.model.Image;
import com.rocketteam.jobfull.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public Image save(MultipartFile newImage) throws IOException {

        Image dbImage = new Image();
        dbImage.setContent(newImage.getBytes());
        return imageRepository.save(dbImage);
    }

    @Override
    public Image findById(Long imageId) {
        return imageRepository.getOne(imageId);
    }

    @Override
    public Image updateImage(Long imageId, Image updatedImage) {
        Image existingImage = imageRepository.findById(imageId).get();
        if (updatedImage.getName() != null) existingImage.setName(updatedImage.getName());
        if (updatedImage.getContent() != null) existingImage.setContent(updatedImage.getContent());
        return imageRepository.save(existingImage);
    }
}