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
public void setEmployeeId(String employeeId){
    this.employeeId=employeeId;
}
public String getUsername(){
  return username;
}
public void setUsername(String Username){
    this.username=username;
}
public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email=email;
}
public String getPassword(){
    return password;
}
public void SetPassword(String password){
    this.password=password;
}
public String getRole(){
    return role;
}
public void setRole(String role){
    this.role=role;
}
public void

}