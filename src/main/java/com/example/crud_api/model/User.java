package com.example.crud_api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Data;
import java.util.UUID;

@Data
public class User {
    
    @Null(message = "ID must be null and will be generated automatically")
    private UUID id; 

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 120, message = "Age must be realistic")
    private int age;

    // Default constructor (needed for JSON deserialization)
    public User() {}

    // Parameterized constructor
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
