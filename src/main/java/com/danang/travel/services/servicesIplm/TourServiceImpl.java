package com.danang.travel.services.servicesIplm;

import com.danang.travel.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl {

    @Autowired
    private TourRepository tourRepository;
}
