package com.befit.dataTransferObject;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Email is Required")
    @Email(message = "Please enter valid Email")
    private String email;

    @NotBlank(message = "First Name is required")
    @Size(min=3, message = "Name should be atleast of 3 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @NotBlank(message = "Password required")
    @Size(min=8, message = "Password must be atleast of 6 characters")
    private String password;
}
