package com.geminiIntegrate.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Gemini_recommended")
@Data
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private Long activityId;
    private String activityType;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    @CreatedDate
    private LocalDateTime createdAt;
}

