package com.danang.travel.services.servicesIplm;

import com.danang.travel.models.dao.Tour;
import com.danang.travel.models.dao.TourSchedule;
import com.danang.travel.repositories.TourRepository;
import com.danang.travel.repositories.TourScheduleRepository;
import com.danang.travel.services.TourScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourScheduleServiceImpl implements TourScheduleService {

    @Autowired
    private TourScheduleRepository tourScheduleRepository;

    @Autowired
    private TourRepository tourRepository;

    @Override
    public List<TourSchedule> getAllTourSchedules() {
        return tourScheduleRepository.findAll();
    }

    @Override
    public TourSchedule getTourScheduleByTourId(Integer tourId) {
        return tourRepository.findById(tourId).get().getTourSchedule();
    }

    @Override
    public TourSchedule getTourScheduleById(Integer tourScheduleId) {
        return tourScheduleRepository.findById(tourScheduleId).get();
    }

    @Override
    public TourSchedule addTourSchedule(Integer tourId, TourSchedule tourSchedule) {
        TourSchedule tourScheduleAdd = tourScheduleRepository.save(tourSchedule);
        Tour tour = tourRepository.findById(tourId).get();
        tour.setTourSchedule(tourScheduleAdd);
        tourRepository.save(tour);
        return tourScheduleAdd;
    }

    @Override
    public TourSchedule updateTourSchedule(Integer tourId, TourSchedule tourSchedule) {
        Tour tour = tourRepository.findById(tourId).get();
        TourSchedule tourScheduleUpdate = tour.getTourSchedule();
        tourScheduleUpdate.setDescription(tourSchedule.getDescription());
        tour.setTourSchedule(tourScheduleUpdate);
        tourRepository.save(tour);
        return tourScheduleUpdate;
    }

    @Override
    public void deleteTourSchedule(Integer tourId) {
        Tour tour = tourRepository.findById(tourId).get();
        TourSchedule tourSchedule = tour.getTourSchedule();
        tour.setTourSchedule(null);
        tourScheduleRepository.delete(tourSchedule);
        tourRepository.save(tour);
    }
}
