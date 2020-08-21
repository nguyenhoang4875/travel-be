package com.danang.travel.services;

import com.danang.travel.models.dto.TourDto;

import java.util.List;

public interface TourService {

    List<TourDto> getAllTours();

    TourDto getTourById(Integer tourId);

    TourDto addTour(TourDto tourDto);

    TourDto updateTour(TourDto tourDto);

    void deleteTour(Integer tourId);

}
