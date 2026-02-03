package com.activities.services;

import com.activities.DataTransferObject.ActivityRequest;
import com.activities.DataTransferObject.ActivityResponse;
import com.activities.model.Activity;
import com.activities.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    //activity creation and record;
    public ActivityResponse trackActivity(ActivityRequest request) {

        LocalDateTime now = LocalDateTime.now();

        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .activityType(request.getActivityType())
                .calories(request.getCalories())
                .duration(request.getDuration())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .creationTime(now)
                .updateTime(now)
                .build();
        Activity savedActivity = activityRepository.save(activity);

        return convertToActivityResponse(savedActivity);
    }
    private ActivityResponse convertToActivityResponse(Activity activity) {
        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setId(activity.getId());
        activityResponse.setUserId(activity.getUserId());
        activityResponse.setActivityType(activity.getActivityType());
        activityResponse.setCalories(activity.getCalories());
        activityResponse.setDuration(activity.getDuration());
        activityResponse.setStartTime(activity.getStartTime());
        activityResponse.setEndTime(activity.getEndTime());
        activityResponse.setCreationTime(activity.getCreationTime());
        activityResponse.setUpdateTime(activity.getUpdateTime());
        return activityResponse;
    }
    //List all user activities
    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> activities = activityRepository.findByUserId(userId);
        return activities.stream()
                .map(this::convertToActivityResponse)
                .collect(Collectors.toList());
    }

    public ActivityResponse getActivity(Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found with id: " + activityId));
        return convertToActivityResponse(activity);
    }

    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}
