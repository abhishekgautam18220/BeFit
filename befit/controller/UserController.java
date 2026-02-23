package com.befit.controller;

import com.befit.dataTransferObject.RegisterRequest;
import com.befit.dataTransferObject.UserResponse;
import com.befit.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return "working";
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserId(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest register) {
        return ResponseEntity.ok(userService.register(register));
    }

    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable String userId){
        return ResponseEntity.ok(userService.existsUserById(userId));
    }

}
