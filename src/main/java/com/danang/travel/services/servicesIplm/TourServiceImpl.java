package com.danang.travel.services.servicesIplm;

import com.danang.travel.converter.TourDtoToTourDaoConverter;
import com.danang.travel.converter.bases.Converter;
import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dao.Tour;
import com.danang.travel.models.dto.TourDto;
import com.danang.travel.models.dto.TourHomeDto;
import com.danang.travel.repositories.ImageRepository;
import com.danang.travel.repositories.TourRepository;
import com.danang.travel.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private Converter<Tour, TourDto> tourDaoToTourDtoConverter;

    @Autowired
    private Converter<Tour, TourHomeDto> tourDaoToTourHomeDtoConverter;

    @Autowired
    private TourDtoToTourDaoConverter tourDtoToTourConverter;

    @Override
    public List<TourDto> getAllTours() {
        return tourDaoToTourDtoConverter.convert(tourRepository.findAll());
    }

    @Override
    public TourDto getTourById(Integer tourId) {
        return tourDaoToTourDtoConverter.convert(tourRepository.findById(tourId).get());
    }

    @Override
    public Image addImageByTourId(Integer tourId, String url) {
        Tour tour = tourRepository.findById(tourId).get();
        Image image = imageRepository.save(new Image(0, url));
        tour.getImages().add(image);
        tourRepository.save(tour);
        return image;
    }

    @Override
    public TourDto addTour(TourDto tourDto) {
        Tour tour = tourDtoToTourConverter.convert(tourDto);
        tourDto.setId(tourRepository.save(tour).getId());
        return tourDto;
    }

    @Override
    public void addPosterByTourId(Integer tourId, String posterUrl) {
        Tour tour = tourRepository.findById(tourId).get();
        tour.setPoster(posterUrl);
        tourRepository.save(tour);
    }

    @Override
    public TourDto updateTour(TourDto tourDto) {
        Tour tour = tourDtoToTourConverter.convertForEdit(tourDto);
        tourRepository.save(tour);
        return tourDaoToTourDtoConverter.convert(tour);
    }

    @Override
    public void deleteTour(Integer tourId) {
        tourRepository.deleteById(tourId);
    }

    @Override
    public List<Image> getImagesByTourId(Integer tourId) {
        return tourRepository.findById(tourId).get().getImages();
    }

    @Override
    public void deleteImage(Integer tourId, Integer id) {
        Tour tour = tourRepository.findById(tourId).get();
        tour.getImages().remove(imageRepository.findById(id).get());
        tourRepository.save(tour);
    }

    @Override
    public List<TourHomeDto> getAllHomeTours() {
        return tourDaoToTourHomeDtoConverter.convert(tourRepository.findAll());
    }
}
