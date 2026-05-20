package com.geminiIntegrate.services;

import com.geminiIntegrate.model.Activity;
import com.geminiIntegrate.model.Recommendation;
import com.geminiIntegrate.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {

//    @Value("${rabbitmq.queue.name}")
//    private String queueActivity;
    private final ActivityAIService aiServices;
    private final RecommendationRepository recommendationRepository;
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void processActivity(Activity activity) {
        try {
            log.info("Received activity for processing: {}", activity);
            Recommendation recommendation = aiServices.generateRecommendation(activity);
            recommendationRepository.save(recommendation);
            log.info("Saved successfully for activityId: {}", activity.getId());
        } catch (WebClientResponseException.TooManyRequests e) {
            log.warn("Gemini rate limited, waiting 30 seconds before retry...");
            try {
                Thread.sleep(30000); // wait 30s before RabbitMQ redelivers
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            throw e; // rethrow so RabbitMQ redelivers after the wait
        } catch (Exception e) {
            log.error("Failed to process activity: {}", e.getMessage(), e);
        }
    }
}
