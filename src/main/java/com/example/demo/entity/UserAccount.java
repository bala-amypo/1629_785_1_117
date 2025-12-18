package com.example.demo.entity

import jakarta.persistence.*;
import java.time.LocalDateTime;



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
private LocalDateTime createdAt;

public UserAccount(){

}
public Long getId(){
    return id;
}
public void setId(Long id){
    this.id=id;
}
public String getEmployeeId(){
    return employeeId;
}
public void
}