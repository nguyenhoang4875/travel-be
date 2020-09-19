package com.danang.travel.controllers;

import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dao.TicketVisit;
import com.danang.travel.services.TicketVisitService;
import com.danang.travel.services.servicesIplm.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/ticket-visits")
public class TicketVisitController {

    @Autowired
    private TicketVisitService ticketVisitService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public List<TicketVisit> getAllTicketVisits() {
        return ticketVisitService.getAllTicketVisits();
    }

    @GetMapping("/{ticketVisitId}")
    public TicketVisit getTicketVisitById(@PathVariable Integer ticketVisitId) {
        return this.ticketVisitService.getTicketVisitById(ticketVisitId);
    }

    @PostMapping
    public TicketVisit addTicketVisit(@RequestBody TicketVisit visitTicket) {
        visitTicket.setId(0);
        return ticketVisitService.addTicketVisit(visitTicket);
    }

    @PutMapping
    public TicketVisit updateTicketVisit(@RequestBody TicketVisit visitTicket) {
        return ticketVisitService.updateTicketVisit(visitTicket);
    }

    @DeleteMapping("/{ticketVisitId}")
    public void deleteTicketVisit(@PathVariable Integer ticketVisitId) {
        ticketVisitService.deleteTicketVisit(ticketVisitId);
    }

    @PostMapping("/{visitTicketId}/images")
    public String  addImageByTicketVisitId(@PathVariable Integer visitTicketId, @RequestParam("file") MultipartFile file) {
        String url = cloudinaryService.uploadFile(file);
        ticketVisitService.addImageByTicketVisitId(visitTicketId,url);
        return url;
    }

    @GetMapping("/{visitTicketId}/images")
    public List<Image> getImagesByTicketVisitId(@PathVariable Integer visitTicketId){
        return ticketVisitService.getImagesByTicketVisitId(visitTicketId);
    }

    @DeleteMapping("/{visitTicketId}/images/{id}")
    public void deleteImage(@PathVariable Integer visitTicketId, @PathVariable Integer id){
        ticketVisitService.deleteImage(visitTicketId, id);
    }

}
