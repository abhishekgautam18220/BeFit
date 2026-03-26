package com.geminiIntegrate.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@Service
public class GeminiService {
    @Value("${gemini.api.url}")
    private String geminiAPI;

    private final WebClient webClient;

    public GeminiService(WebClient.Builder webClientbuilder) {
        this.webClient = webClientbuilder.build();
    }

    public String getAnswer(String prompt){
        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                Map.of(
                "parts", List.of(
                Map.of("text", prompt)
                                )
                        )
                )
        );
        return webClient.post()
                .uri(geminiAPI)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
