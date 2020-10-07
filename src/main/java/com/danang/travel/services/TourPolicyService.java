package com.danang.travel.services;

import com.danang.travel.models.dao.TourPolicy;

import java.util.List;

public interface TourPolicyService {

    List<TourPolicy> getAllTourPolicies();

    TourPolicy getTourPolicyByTourId(Integer tourPolicyId);

    TourPolicy getTourPolicyById(Integer tourPolicyId);

    TourPolicy addTourPolicy(Integer tourId, TourPolicy tourPolicy);

    TourPolicy updateTourPolicy(Integer tourId, TourPolicy tourPolicy);

    void deleteTourPolicy(Integer tourId);

}
