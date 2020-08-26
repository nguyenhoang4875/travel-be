package com.danang.travel.services.servicesIplm;

import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dao.TicketVisit;
import com.danang.travel.repositories.ImageRepository;
import com.danang.travel.repositories.TicketVisitRepository;
import com.danang.travel.services.TicketVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketVisitServiceImpl implements TicketVisitService {

    @Autowired
    private TicketVisitRepository ticketVisitRepository;

    @Autowired
    private ImageRepository imageRepository;

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

    @Override
    public void addImageByTicketVisitId(Integer ticketVisitId, String url) {
        TicketVisit ticketVisit = ticketVisitRepository.findById(ticketVisitId).get();
        Image image = imageRepository.save(new Image(0, url));
        ticketVisit.getImages().add(image);
        ticketVisitRepository.save(ticketVisit);
    }

    @Override
    public List<Image> getImagesByTicketVisitId(Integer ticketVisitId) {
        return ticketVisitRepository.findById(ticketVisitId).get().getImages();
    }
}
