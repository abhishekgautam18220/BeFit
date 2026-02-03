package com.activities.controller;

import com.activities.DataTransferObject.ActivityRequest;
import com.activities.DataTransferObject.ActivityResponse;
import com.activities.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController{


    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> saveActivity(@RequestBody ActivityRequest request) {
       return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityResponse> updateActivity( @PathVariable Long id, @RequestBody ActivityRequest request) {
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@PathVariable String userId) {
        List<ActivityResponse> activities = activityService.getUserActivities(userId);
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/user/{activityId}")
    public ResponseEntity<ActivityResponse> getActivity(@PathVariable Long activityId) {
        return ResponseEntity.ok(activityService.getActivity(activityId));
    }

    @DeleteMapping("user/{deleteId}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long deleteId) {

        activityService.deleteActivity(deleteId);
        return ResponseEntity.noContent().build();
    }

}
