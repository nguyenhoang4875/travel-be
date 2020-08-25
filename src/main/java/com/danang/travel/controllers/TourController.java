package com.danang.travel.controllers;

import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dto.TourDto;
import com.danang.travel.services.TourService;
import com.danang.travel.services.servicesIplm.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public List<TourDto> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/{tourId}")
    public TourDto getTourById(@PathVariable Integer tourId) {
        return this.tourService.getTourById(tourId);
    }

    @PostMapping
    public TourDto addTour(@RequestBody TourDto tourDto) {
        tourDto.setId(0);
        return tourService.addTour(tourDto);
    }

    @PostMapping("/{tourId}/images")
    public String  addImageByTourId(@PathVariable Integer tourId, @RequestParam("file") MultipartFile file) {
        String url = cloudinaryService.uploadFile(file);
        tourService.addImageByTourId(tourId,url);
        return url;
    }

    @GetMapping("/{tourId}/images")
    public List<Image> getImagesByTourId(@PathVariable Integer tourId){
        return tourService.getImagesByTourId(tourId);
    }

    @PutMapping
    public TourDto updateTour(@RequestBody TourDto tourDto) {
        return tourService.updateTour(tourDto);
    }

    @DeleteMapping("/{tourId}")
    public void deleteTour(@PathVariable Integer tourId) {
        tourService.deleteTour(tourId);
    }

}
