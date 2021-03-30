package com.rocketteam.jobfull.service;


import com.rocketteam.jobfull.model.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImageService {

    Image save(MultipartFile image) throws IOException;
    Image findById(Long imageId);
    Image updateImage(Long imageId, Image image);
}