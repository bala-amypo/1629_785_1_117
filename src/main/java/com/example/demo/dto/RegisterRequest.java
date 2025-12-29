// package com.example.demo.dto;

// import lombok.Getter;
// import lombok.Setter;
// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;

// @Getter @Setter
// public class RegisterRequest {

//     @NotBlank(message = "Username required")
//     private String username;

//     @Email(message = "Invalid email format")
//     @NotBlank(message = "Email required")
//     private String email;

//     @NotBlank(message = "Password required")
//     private String password;

//     private String role;       // ADMIN/USER/AUDITOR
//     private String employeeId; // As per testcases & SRS
// }
