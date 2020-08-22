package com.danang.travel.services.servicesIplm;

import com.danang.travel.models.dao.Promotion;
import com.danang.travel.repositories.PromotionRepository;
import com.danang.travel.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

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
}
