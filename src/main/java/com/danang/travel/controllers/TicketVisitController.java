package com.danang.travel.controllers;

import com.danang.travel.models.dao.TicketVisit;
import com.danang.travel.services.TicketVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ticket-visits")
public class TicketVisitController {

    @Autowired
    private TicketVisitService tourService;

    @GetMapping
    public List<TicketVisit> getAllTicketVisits() {
        return tourService.getAllTicketVisits();
    }

    @GetMapping("/{ticketVisitId}")
    public TicketVisit getTicketVisitById(@PathVariable Integer ticketVisitId) {
        return this.tourService.getTicketVisitById(ticketVisitId);
    }

    @PostMapping
    public TicketVisit addTicketVisit(@RequestBody TicketVisit tourDto) {
        tourDto.setId(0);
        return tourService.addTicketVisit(tourDto);
    }

    @PutMapping
    public TicketVisit updateTicketVisit(@RequestBody TicketVisit tourDto) {
        return tourService.updateTicketVisit(tourDto);
    }

    @DeleteMapping("/{ticketVisitId}")
    public void deleteTicketVisit(@PathVariable Integer ticketVisitId) {
        tourService.deleteTicketVisit(ticketVisitId);
    }

}
