package com.danang.travel.controllers;

import com.danang.travel.models.dao.TourPolicy;
import com.danang.travel.services.TourPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/tour-policies")
public class TourPolicyController {

    @Autowired
    private TourPolicyService tourPolicyService;

    @GetMapping
    public List<TourPolicy> getAllTourPolicies() {
        return tourPolicyService.getAllTourPolicies();
    }

    @GetMapping("tours/{tourId}")
    public TourPolicy getTourPolicyByTourId(@PathVariable Integer tourId) {
        return this.tourPolicyService.getTourPolicyByTourId(tourId);
    }

    @GetMapping("{tourPolicyId}")
    public TourPolicy getTourPolicyById(@PathVariable Integer tourPolicyId) {
        return this.tourPolicyService.getTourPolicyById(tourPolicyId);
    }

    @PostMapping("/{tourId}")
    public TourPolicy addTourPolicy(@PathVariable Integer tourId, @RequestBody TourPolicy tourPolicy) {
        tourPolicy.setId(0);
        return tourPolicyService.addTourPolicy(tourId, tourPolicy);
    }

    @PutMapping("/{tourId}")
    public TourPolicy updateTourPolicy(@PathVariable Integer tourId, @RequestBody TourPolicy tourPolicy) {
        return tourPolicyService.updateTourPolicy(tourId, tourPolicy);
    }

    @DeleteMapping("/{tourId}")
    public void deleteTourPolicy(@PathVariable Integer tourId) {
        tourPolicyService.deleteTourPolicy(tourId);
    }
}
