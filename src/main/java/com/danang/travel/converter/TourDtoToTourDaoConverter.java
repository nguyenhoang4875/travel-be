package com.danang.travel.converter;

import com.danang.travel.converter.bases.Converter;
import com.danang.travel.models.dao.Tour;
import com.danang.travel.models.dto.TourDto;
import com.danang.travel.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TourDtoToTourDaoConverter extends Converter<TourDto, Tour> {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public Tour convert(TourDto source) {
        Tour tour = new Tour();
        tour.setId(source.getId());
        tour.setName(source.getName());
        tour.setAddress(source.getAddress());
        tour.setDuration(source.getDuration());
        tour.setPrice(source.getPrice());
        return tour;
    }

    public Tour convertForEdit( TourDto source) {
        Tour tour = tourRepository.findById(source.getId()).get();
        tour.setName(source.getName());
        tour.setAddress(source.getAddress());
        tour.setDuration(source.getDuration());
        tour.setPrice(source.getPrice());
        return  tour;
    }
}