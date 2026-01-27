package com.befit.services;

import com.befit.dataTransferObject.RegisterRequest;
import com.befit.dataTransferObject.UserResponse;
import com.befit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.befit.model.User;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    //register new user in user controller
    public UserResponse register(RegisterRequest register) {

        if (userRepository.existsByEmail(register.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setFirstName(register.getFirstName());
        user.setLastName(register.getLastName());
        user.setEmail(register.getEmail());
        user.setPassword(register.getPassword());

        // saving new user that is created "/register" path
        User savedUser = userRepository.save(user);
        UserResponse userResponse = new UserResponse();

        userResponse.setId(savedUser.getId());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setModifiedAt(savedUser.getModifiedAt());
        return userResponse;
    }
    //Show profile in user controller "/userId" path
    public UserResponse getUserProfile(String userId){
        User user = userRepository.findById(userId).
                orElseThrow( () ->new RuntimeException("User Not Found"));

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setModifiedAt(user.getModifiedAt());

        return userResponse;
    }

}


