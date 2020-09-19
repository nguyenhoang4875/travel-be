package com.danang.travel.controllers;

import com.danang.travel.models.dao.Guide;
import com.danang.travel.models.dao.Image;
import com.danang.travel.services.GuideService;
import com.danang.travel.services.servicesIplm.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/guides")
public class GuideController {

    @Autowired
    private GuideService guideService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public List<Guide> getAllGuides() {
        return guideService.getAllGuides();
    }

    @GetMapping("/{guideId}")
    public Guide getGuideById(@PathVariable Integer guideId) {
        return this.guideService.getGuideById(guideId);
    }

    @PostMapping
    public Guide addGuide(@RequestBody Guide guide) {
        guide.setId(0);
        return guideService.addGuide(guide);
    }

    @PutMapping
    public Guide updateGuide(@RequestBody Guide guide) {
        return guideService.updateGuide(guide);
    }

    @DeleteMapping("/{guideId}")
    public void deleteGuide(@PathVariable Integer guideId) {
        guideService.deleteGuide(guideId);
    }

    @PostMapping("/{guideId}/images")
    public String  addImageByGuideId(@PathVariable Integer guideId, @RequestParam("file") MultipartFile file) {
        String url = cloudinaryService.uploadFile(file);
        guideService.addImageByGuideId(guideId,url);
        return url;
    }

    @GetMapping("/{guideId}/images")
    public List<Image> getImagesByGuideId(@PathVariable Integer guideId){
        return guideService.getImagesByGuideId(guideId);
    }


}
