// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;

// import java.time.LocalDateTime;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Table(name = "user_accounts")
// public class UserAccount {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String employeeId;

//     @Column(unique = true)
//     private String username;

//     @Column(unique = true)
//     private String email;

//     private String password;
//     private String role;
//     private String status;
//     private LocalDateTime createdAt;

//     @PrePersist
//     protected void onCreate() {
//         this.createdAt = LocalDateTime.now();
//         if (this.status == null) {
//             this.status = "ACTIVE";
//         }
//     }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeId;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private LocalDateTime createdAt;

    public UserAccount() {}

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = AccountStatus.ACTIVE;
        }
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
