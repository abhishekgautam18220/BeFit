package com.activities.DataTransferObject;

import com.activities.model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityResponse {
    private Long id;
    private String userId;
    private ActivityType activityType;
    private Integer duration;
    private Integer calories;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;

}
