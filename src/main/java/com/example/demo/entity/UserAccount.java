package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class UserAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String username;
    private String role;
    private String status;
    private String employeeId;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LoginEvent> loginEvents;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DeviceProfile> devices;
}







// package com.example.demo.entity;

// import java.time.LocalDateTime;

// public class UserAccount {
//     private Long id;
//     private String email;
//     private String password;
//     private String username;
//     private String status;
//     private String role;
//     private String employeeId;
//     private LocalDateTime createdAt;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }

//     public String getEmployeeId() { return employeeId; }
//     public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
// }
