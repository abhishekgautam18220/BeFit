package com.geminiIntegrate.model;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
public class Activity {

    private Long id;
    private String userId;
    private String Type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
}
