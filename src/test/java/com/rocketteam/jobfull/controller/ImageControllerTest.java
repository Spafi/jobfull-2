package com.rocketteam.jobfull.controller;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Image;
import com.rocketteam.jobfull.model.JobHunter;
import com.rocketteam.jobfull.service.ImageService;
import com.sun.istack.Nullable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ImageControllerTest {

    public JobHunter mockJobHunter(){
        JobHunter jobHunter = new JobHunter();
        jobHunter.setFirstName("Jon");
        jobHunter.setLastName("Dan");
        jobHunter.setPhoneNumber("123456");
        jobHunter.setPassword("test123");
        jobHunter.setEmail("jon@dan");
        jobHunter.setId(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35901"));
        return jobHunter;
    }

    Company mockCompany(){
        Company company = new Company();
        company.setAddress("Street");
        company.setCity("Bucuresti");
        company.setCountry("Romania");
        company.setName("CodeCool");
        company.setDescription("Programming school");
        company.setEmail("code@cool");
        company.setPassword("CodeCool");
        company.setPhoneNumber("123456");
        company.setTradeRegisterSerialNumber("021");
        company.setUniqueRegistrationCode("999");
        company.setWebsite("learn.code.cool");
        company.setId(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8"));
        return company;
    }

    MultipartFile mockMultipartFile(){
        MultipartFile multipartFile = new MultipartFile() {
            @Override
            public String getName() {
                return "Test";
            }

            @Override
            public String getOriginalFilename() {
                return "Untitled";
            }

            @Override
            public String getContentType() {
                return "Empty";
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public void transferTo(File file) throws IOException, IllegalStateException {

            }
        };
        return multipartFile;
    }

    Image mockImage(){
       Image image = new Image();
       image.setId(1L);
       image.setCompanyId(UUID.fromString("5c6ba2d5-b5a4-4665-a067-0ab29996dce8"));
       image.setName("Untitled");
       image.setJobHunterId(UUID.fromString("93d34cf4-8391-4659-bacd-318bf3e35901"));
       return image;
    }


//Nu cred ca e corect
    @Test
    void uploadImage() throws IOException {
        //return image
        ImageService imageService = Mockito.mock(ImageService.class);
        Mockito.when(imageService.save(mockMultipartFile())).thenReturn(null);
        Image result = imageService.save(mockMultipartFile());
        assertEquals(result, null);


    }

    @Test
    void downloadImage() {
        //return resource
        ImageService imageService = Mockito.mock(ImageService.class);
        Mockito.when(imageService.findById(1L)).thenReturn(mockImage());
        Image result = imageService.findById(mockImage().getId());
        assertEquals(result.getCompanyId(), mockImage().getCompanyId());
        assertEquals(result.getName(), mockImage().getName());
        assertEquals(result.getJobHunterId(), mockImage().getJobHunterId());
    }


    @Test
    void updateImage() {
        ImageService imageService = Mockito.mock(ImageService.class);
        Mockito.when(imageService.updateImage(1L, mockImage())).thenReturn(mockImage());
        Image result = imageService.updateImage(1L, mockImage());
        assertEquals(result, mockImage());
    }
}