package com.danang.travel.controllers;

import com.danang.travel.models.dto.TourDto;
import com.danang.travel.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping
    public List<TourDto> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/{tourId}")
    public TourDto getTourById(@PathVariable Integer tourId){
        return this.tourService.getTourById(tourId);
    }

    @PostMapping
    public TourDto addTour(@RequestBody TourDto tourDto) {
        tourDto.setId(0);
        return tourService.addTour(tourDto);
    }

    @PutMapping
    public TourDto updateTour(@RequestBody TourDto tourDto) {
        return tourService.updateTour(tourDto);
    }

    @DeleteMapping("/{tourId}")
    public void deleteTour(@PathVariable Integer tourId){
        tourService.deleteTour(tourId);
    }

}
