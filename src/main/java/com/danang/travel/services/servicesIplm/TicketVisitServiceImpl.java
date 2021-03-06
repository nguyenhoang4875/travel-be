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
        TicketVisit ticketVisitUpdate = ticketVisitRepository.findById(ticketVisit.getId()).get();
        ticketVisitUpdate.setName(ticketVisit.getName());
        ticketVisitUpdate.setDescription(ticketVisit.getDescription());
        ticketVisitUpdate.setPrice(ticketVisit.getPrice());
        return ticketVisitRepository.save(ticketVisitUpdate);
    }

    @Override
    public void deleteTicketVisit(Integer ticketVisitId) {
        ticketVisitRepository.deleteById(ticketVisitId);
    }

    @Override
    public Image addImageByTicketVisitId(Integer ticketVisitId, String url) {
        TicketVisit ticketVisit = ticketVisitRepository.findById(ticketVisitId).get();
        Image image = imageRepository.save(new Image(0, url));
        ticketVisit.getImages().add(image);
        ticketVisitRepository.save(ticketVisit);
        return image;
    }

    @Override
    public List<Image> getImagesByTicketVisitId(Integer ticketVisitId) {
        return ticketVisitRepository.findById(ticketVisitId).get().getImages();
    }

    @Override
    public void deleteImage(Integer visitTicketId, Integer id) {
        TicketVisit ticketVisit = ticketVisitRepository.findById(visitTicketId).get();
        ticketVisit.getImages().remove(imageRepository.findById(id).get());
        ticketVisitRepository.save(ticketVisit);

    }
}
