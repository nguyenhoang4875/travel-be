package com.danang.travel.converter.bases;

import com.danang.travel.models.dao.Tour;
import com.danang.travel.models.dto.TourDto;
import org.springframework.stereotype.Component;

@Component
public class TourDtoToTourDaoConverter extends Converter<TourDto, Tour> {
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
}
