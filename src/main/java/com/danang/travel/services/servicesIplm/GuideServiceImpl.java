package com.danang.travel.services.servicesIplm;

import com.danang.travel.models.dao.Guide;
import com.danang.travel.repositories.GuideRepository;
import com.danang.travel.services.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideRepository guideRepository;

    @Override
    public List<Guide> getAllGuides() {
        return guideRepository.findAll();
    }

    @Override
    public Guide getGuideById(Integer guideId) {
        return guideRepository.findById(guideId).get();
    }

    @Override
    public Guide addGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    @Override
    public Guide updateGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    @Override
    public void deleteGuide(Integer guideId) {
        guideRepository.deleteById(guideId);
    }
}
