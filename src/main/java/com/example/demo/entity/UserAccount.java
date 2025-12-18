package com.example.demo.entity
 import jakarta.persistence.*;


@Entity
public class UserAccount{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long id;
private String employeeId;
private String username;
private String email;
private String passsword;
private String role;
private String status;
private LocalDateTime
}