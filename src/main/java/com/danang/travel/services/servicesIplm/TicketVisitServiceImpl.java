package com.danang.travel.services.servicesIplm;

import com.danang.travel.models.dao.TicketVisit;
import com.danang.travel.repositories.TicketVisitRepository;
import com.danang.travel.services.TicketVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketVisitServiceImpl implements TicketVisitService {

    @Autowired
    private TicketVisitRepository ticketVisitRepository;

    @Override
    public List<TicketVisit> getAllTicketVisits() {
        return ticketVisitRepository.findAll();
    }

    @Override
    public TicketVisit getTicketVisitById(Integer ticketVisitId) {
        return ticketVisitRepository.findById(ticketVisitId).get();
    }

    @Override
    public TicketVisit addTicketVisit(TicketVisit ticketVisit) {
        return ticketVisitRepository.save(ticketVisit);
    }

    @Override
    public TicketVisit updateTicketVisit(TicketVisit ticketVisit) {
        return ticketVisitRepository.save(ticketVisit);
    }

    @Override
    public void deleteTicketVisit(Integer ticketVisitId) {
        ticketVisitRepository.deleteById(ticketVisitId);
    }
}
