package com.befit.controller;

import com.befit.dataTransferObject.RegisterRequest;
import com.befit.dataTransferObject.UserResponse;
import com.befit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userId")
    public ResponseEntity<UserResponse> getUserId(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }
}
