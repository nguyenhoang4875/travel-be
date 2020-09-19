package com.danang.travel.controllers;

import com.danang.travel.services.servicesIplm.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("api/images")
public class UploadImageController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String url = cloudinaryService.uploadFile(file);
        return url;
    }
}
