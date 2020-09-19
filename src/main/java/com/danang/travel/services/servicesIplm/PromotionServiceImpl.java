package com.danang.travel.services.servicesIplm;

import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dao.Promotion;
import com.danang.travel.models.dao.Tour;
import com.danang.travel.repositories.ImageRepository;
import com.danang.travel.repositories.PromotionRepository;
import com.danang.travel.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion getPromotionById(Integer promotionId) {
        return promotionRepository.findById(promotionId).get();
    }

    @Override
    public Promotion addPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion updatePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public void deletePromotion(Integer promotionId) {
        promotionRepository.deleteById(promotionId);
    }

    @Override
    public void addImageByPromotionId(Integer promotionId, String url) {
        Promotion promotion = promotionRepository.findById(promotionId).get();
        Image image = imageRepository.save(new Image(0,url));
        promotion.getImages().add(image);
        promotionRepository.save(promotion);
    }

    @Override
    public List<Image> getImagesByPromotionId(Integer promotionId) {
        return promotionRepository.findById(promotionId).get().getImages();
    }

    @Override
    public void deleteImage(Integer promotionId, Integer id) {
        Promotion promotion= promotionRepository.findById(promotionId).get();
        promotion.getImages().remove(imageRepository.findById(id).get());
        promotionRepository.save(promotion);
    }
}
