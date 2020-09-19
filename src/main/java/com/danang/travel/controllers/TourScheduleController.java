package com.danang.travel.controllers;

import com.danang.travel.models.dao.TourSchedule;
import com.danang.travel.services.TourScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/tour-schedules")
public class TourScheduleController {

    @Autowired
    private TourScheduleService tourScheduleService;

    @GetMapping
    public List<TourSchedule> getAllTourSchedules() {
        return tourScheduleService.getAllTourSchedules();
    }

    @GetMapping("tours/{tourId}")
    public TourSchedule getTourScheduleByTourId(@PathVariable Integer tourId) {
        return this.tourScheduleService.getTourScheduleByTourId(tourId);
    }

    @GetMapping("{tourScheduleId}")
    public TourSchedule getTourScheduleById(@PathVariable Integer tourScheduleId) {
        return this.tourScheduleService.getTourScheduleById(tourScheduleId);
    }

    @PostMapping("/{tourId}")
    public TourSchedule addTourSchedule(@PathVariable Integer tourId, @RequestBody TourSchedule tourSchedule) {
        tourSchedule.setId(0);
        return tourScheduleService.addTourSchedule(tourId, tourSchedule);
    }

    @PutMapping("/{tourId}")
    public TourSchedule updateTourSchedule(@PathVariable Integer tourId, @RequestBody TourSchedule tourSchedule) {
        return tourScheduleService.updateTourSchedule(tourId, tourSchedule);
    }

    @DeleteMapping("/{tourId}")
    public void deleteTourSchedule(@PathVariable Integer tourId) {
        tourScheduleService.deleteTourSchedule(tourId);
    }
}
