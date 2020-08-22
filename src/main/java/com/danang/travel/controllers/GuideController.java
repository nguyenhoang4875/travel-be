package com.danang.travel.controllers;

import com.danang.travel.models.dao.Guide;
import com.danang.travel.services.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/guides")
public class GuideController {

    @Autowired
    private GuideService guideService;

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

}
