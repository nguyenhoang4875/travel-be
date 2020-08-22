package com.danang.travel.services;

import com.danang.travel.models.dao.TicketVisit;

import java.util.List;

public interface TicketVisitService {

    List<TicketVisit> getAllTicketVisits();

    TicketVisit getTicketVisitById(Integer ticketVisitId);

    TicketVisit addTicketVisit(TicketVisit ticketVisit);

    TicketVisit updateTicketVisit(TicketVisit ticketVisit);

    void deleteTicketVisit(Integer ticketVisitId);

}
