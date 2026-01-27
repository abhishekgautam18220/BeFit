package com.befit.repository;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.befit.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmail(@NotBlank(message = "Email is Required")
                          @Email(message = "Please enter valid Email") String email);
}
