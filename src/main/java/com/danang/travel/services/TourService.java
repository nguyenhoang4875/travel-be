package com.danang.travel.services;

import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dto.TourDto;

import java.util.List;

public interface TourService {

    List<TourDto> getAllTours();

    TourDto getTourById(Integer tourId);

    void addImageByTourId(Integer tourId, String url);

    TourDto addTour(TourDto tourDto);

    void addPosterByTourId(Integer tourId,String  posterUrl);

    TourDto updateTour(TourDto tourDto);

    void deleteTour(Integer tourId);

    List<Image> getImagesByTourId(Integer tourId);

    void deleteImage(Integer tourId, Integer id);
}
