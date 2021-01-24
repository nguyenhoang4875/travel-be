package com.danang.travel.converter;

import com.danang.travel.converter.bases.Converter;
import com.danang.travel.models.dao.Tour;
import com.danang.travel.models.dto.TourDto;
import com.danang.travel.models.dto.TourHomeDto;
import org.springframework.stereotype.Component;

@Component
public class TourDaoToTourHomeDtoConverter extends Converter<Tour, TourHomeDto> {
    @Override
    public TourHomeDto convert(Tour source) {
        TourHomeDto tourHomeDto = new TourHomeDto();
        tourHomeDto.setId(source.getId());
        tourHomeDto.setName(source.getName());
        tourHomeDto.setAddress(source.getAddress());
        tourHomeDto.setDuration(source.getDuration());
        tourHomeDto.setPrice(source.getPrice());
        tourHomeDto.setPoster(source.getPoster());
        tourHomeDto.setType(source.getType());
        return tourHomeDto;
    }
}
