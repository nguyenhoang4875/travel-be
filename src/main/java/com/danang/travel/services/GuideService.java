package com.danang.travel.services;

import com.danang.travel.models.dao.Guide;
import com.danang.travel.models.dao.Image;

import java.util.List;

public interface GuideService {

    List<Guide> getAllGuides();

    Guide getGuideById(Integer guideId);

    Guide addGuide(Guide guide);

    Guide updateGuide(Guide guide);

    void deleteGuide(Integer guideId);

    void addImageByGuideId(Integer tourId, String url);

    List<Image> getImagesByGuideId(Integer tourId);
}
