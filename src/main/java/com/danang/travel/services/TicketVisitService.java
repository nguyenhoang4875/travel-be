package com.danang.travel.services;

import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dao.TicketVisit;

import java.util.List;

public interface TicketVisitService {

    List<TicketVisit> getAllTicketVisits();

    TicketVisit getTicketVisitById(Integer ticketVisitId);

    TicketVisit addTicketVisit(TicketVisit ticketVisit);

    TicketVisit updateTicketVisit(TicketVisit ticketVisit);

    void deleteTicketVisit(Integer ticketVisitId);

    void addImageByTicketVisitId(Integer ticketVisitId, String url);

    List<Image> getImagesByTicketVisitId(Integer ticketVisitId);

    void deleteImage(Integer visitTicketId, Integer id);
}
