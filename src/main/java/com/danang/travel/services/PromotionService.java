package com.danang.travel.services;

import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dao.Promotion;

import java.util.List;

public interface PromotionService {

    List<Promotion> getAllPromotions();

    Promotion getPromotionById(Integer promotionId);

    Promotion addPromotion(Promotion promotion);

    Promotion updatePromotion(Promotion promotion);

    void deletePromotion(Integer promotionId);

    void addImageByPromotionId(Integer promotionId, String url);

    List<Image> getImagesByPromotionId(Integer promotionId);
}
