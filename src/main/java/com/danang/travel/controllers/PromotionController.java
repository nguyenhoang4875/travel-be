package com.danang.travel.controllers;

import com.danang.travel.models.dao.Image;
import com.danang.travel.models.dao.Promotion;
import com.danang.travel.services.PromotionService;
import com.danang.travel.services.servicesIplm.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @GetMapping("/{promotionId}")
    public Promotion getPromotionById(@PathVariable Integer promotionId) {
        return this.promotionService.getPromotionById(promotionId);
    }

    @PostMapping
    public Promotion addPromotion(@RequestBody Promotion promotion) {
        promotion.setId(0);
        return promotionService.addPromotion(promotion);
    }

    @PutMapping
    public Promotion updatePromotion(@RequestBody Promotion promotion) {
        return promotionService.updatePromotion(promotion);
    }

    @DeleteMapping("/{promotionId}")
    public void deletePromotion(@PathVariable Integer promotionId) {
        promotionService.deletePromotion(promotionId);
    }

    @PostMapping("/{promotionId}/images")
    public String  addImageByPromotionId(@PathVariable Integer promotionId, @RequestParam("file") MultipartFile file) {
        String url = cloudinaryService.uploadFile(file);
        promotionService.addImageByPromotionId(promotionId,url);
        return url;
    }

    @GetMapping("/{promotionId}/images")
    public List<Image> getImagesByPromotionId(@PathVariable Integer promotionId){
        return promotionService.getImagesByPromotionId(promotionId);
    }

    @DeleteMapping("/{promotionId}/images/{id}")
    public void deleteImage(@PathVariable Integer promotionId, @PathVariable Integer id){
        promotionService.deleteImage(promotionId, id);
    }


}
