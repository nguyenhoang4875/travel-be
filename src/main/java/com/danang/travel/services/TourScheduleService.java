package com.danang.travel.services;

import com.danang.travel.models.dao.TourSchedule;

import java.util.List;

public interface TourScheduleService {

    List<TourSchedule> getAllTourSchedules();

    TourSchedule getTourScheduleByTourId(Integer tourScheduleId);

    TourSchedule getTourScheduleById(Integer tourScheduleId);

    TourSchedule addTourSchedule(Integer tourId, TourSchedule tourSchedule);

    TourSchedule updateTourSchedule(Integer tourId, TourSchedule tourSchedule);

    void deleteTourSchedule(Integer tourId);

}
