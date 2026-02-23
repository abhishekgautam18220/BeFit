package com.geminiIntegrate.services;

import com.geminiIntegrate.model.Recommendation;
import com.geminiIntegrate.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationServices {

    private final RecommendationRepository recommendationRepository;

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }
    public Recommendation getActivityRecommendation(Long activityId) {
        return recommendationRepository.findByActivityId(activityId)
                .orElseThrow(()-> new RuntimeException("Activity Recommendation not found"));
    }
}
