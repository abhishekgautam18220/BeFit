package com.activities.DataTransferObject;

import com.activities.model.ActivityType;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ActivityRequest {
    private String userId;
    private ActivityType activityType;
    private Integer duration;
    private Integer calories;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
