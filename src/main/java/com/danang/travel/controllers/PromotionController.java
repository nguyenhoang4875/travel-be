package com.danang.travel.controllers;

import com.danang.travel.models.dao.Promotion;
import com.danang.travel.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @GetMapping("/{promotionId}")
    public Promotion getPromotionById(@PathVariable Integer promotionId) {
        return this.promotionService.getPromotionById(promotionId);
    }

    @PostMapping
    public Promotion addPromotion(@RequestBody Promotion tourDto) {
        tourDto.setId(0);
        return promotionService.addPromotion(tourDto);
    }

    @PutMapping
    public Promotion updatePromotion(@RequestBody Promotion tourDto) {
        return promotionService.updatePromotion(tourDto);
    }

    @DeleteMapping("/{promotionId}")
    public void deletePromotion(@PathVariable Integer promotionId) {
        promotionService.deletePromotion(promotionId);
    }

}
