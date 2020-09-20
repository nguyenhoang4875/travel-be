package com.danang.travel.services.servicesIplm;

import com.danang.travel.models.dao.Guide;
import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dao.Tour;
import com.danang.travel.repositories.GuideRepository;
import com.danang.travel.repositories.ImageRepository;
import com.danang.travel.services.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideRepository guideRepository;

    @Autowired
    private ImageRepository imageRepository;

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
        Guide guideUpdate = guideRepository.findById(guide.getId()).get();
        guideUpdate.setName(guide.getName());
        guideUpdate.setDescription(guide.getDescription());
        return guideRepository.save(guideUpdate);
    }

    @Override
    public void deleteGuide(Integer guideId) {
        guideRepository.deleteById(guideId);
    }

    @Override
    public Image addImageByGuideId(Integer guideId, String url) {
        Guide guide = guideRepository.findById(guideId).get();
        Image image = imageRepository.save(new Image(0, url));
        guide.getImages().add(image);
        guideRepository.save(guide);
        return  image;
    }

    @Override
    public List<Image> getImagesByGuideId(Integer guideId) {
        return guideRepository.findById(guideId).get().getImages();
    }

    @Override
    public void deleteImage(Integer guideId, Integer id) {
        Guide guide = guideRepository.findById(guideId).get();
        guide.getImages().remove(imageRepository.findById(id).get());
        guideRepository.save(guide);

    }
}
