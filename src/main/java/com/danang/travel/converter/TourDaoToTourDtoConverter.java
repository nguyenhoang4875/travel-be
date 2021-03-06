package com.danang.travel.converter;

import com.danang.travel.converter.bases.Converter;
import com.danang.travel.models.dao.Tour;
import com.danang.travel.models.dto.TourDto;
import org.springframework.stereotype.Component;

@Component
public class TourDaoToTourDtoConverter extends Converter<Tour, TourDto> {
    @Override
    public TourDto convert(Tour source) {
        TourDto tourDto = new TourDto();
        tourDto.setId(source.getId());
        tourDto.setName(source.getName());
        tourDto.setAddress(source.getAddress());
        tourDto.setDuration(source.getDuration());
        tourDto.setPrice(source.getPrice());
        tourDto.setPoster(source.getPoster());
        tourDto.setDescription(source.getDescription());
        tourDto.setType(source.getType());
        tourDto.setTourSchedule(source.getTourSchedule());
        tourDto.setTourPolicy(source.getTourPolicy());
        return tourDto;
    }
}
