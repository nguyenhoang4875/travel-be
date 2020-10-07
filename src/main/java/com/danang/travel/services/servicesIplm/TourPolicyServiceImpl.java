package com.danang.travel.services.servicesIplm;

import com.danang.travel.models.dao.Tour;
import com.danang.travel.models.dao.TourPolicy;
import com.danang.travel.repositories.TourPolicyRepository;
import com.danang.travel.repositories.TourRepository;
import com.danang.travel.services.TourPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPolicyServiceImpl implements TourPolicyService {

    @Autowired
    private TourPolicyRepository tourPolicyRepository;

    @Autowired
    private TourRepository tourRepository;



    @Override
    public List<TourPolicy> getAllTourPolicies() {
        return tourPolicyRepository.findAll();
    }

    @Override
    public TourPolicy getTourPolicyByTourId(Integer tourId) {
        return tourRepository.findById(tourId).get().getTourPolicy();
    }

    @Override
    public TourPolicy getTourPolicyById(Integer tourPolicyId) {
        return tourPolicyRepository.findById(tourPolicyId).get();
    }

    @Override
    public TourPolicy addTourPolicy(Integer tourId, TourPolicy tourPolicy) {
        TourPolicy tourPolicyAdd = tourPolicyRepository.save(tourPolicy);
        Tour tour = tourRepository.findById(tourId).get();
        tour.setTourPolicy(tourPolicyAdd);
        tourRepository.save(tour);
        return tourPolicyAdd;
    }

    @Override
    public TourPolicy updateTourPolicy(Integer tourId, TourPolicy tourPolicy) {
        Tour tour = tourRepository.findById(tourId).get();
        TourPolicy tourPolicyUpdate = tour.getTourPolicy();
        tourPolicyUpdate.setDescription(tourPolicy.getDescription());
        tour.setTourPolicy(tourPolicyUpdate);
        tourRepository.save(tour);
        return tourPolicyUpdate;
    }

    @Override
    public void deleteTourPolicy(Integer tourId) {
        Tour tour = tourRepository.findById(tourId).get();
        TourPolicy tourPolicy = tour.getTourPolicy();
        tour.setTourPolicy(null);
        tourPolicyRepository.delete(tourPolicy);
        tourRepository.save(tour);
    }
}
