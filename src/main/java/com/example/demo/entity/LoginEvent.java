package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "login_event")
public class LoginEvent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;
    private String deviceId;
    private String location;
    private String loginStatus;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)   // only one FK column
    private UserAccount user;
}






// package com.example.demo.entity;

// import java.time.LocalDateTime;

// public class LoginEvent {
//     private Long id;
//     private Long userId;
//     private String loginStatus;
//     private String ipAddress;
//     private String deviceId;
//     private String location;
//     private LocalDateTime timestamp;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getUserId() { return userId; }
//     public void setUserId(Long userId) { this.userId = userId; }

//     public String getLoginStatus() { return loginStatus; }
//     public void setLoginStatus(String loginStatus) { this.loginStatus = loginStatus; }

//     public String getIpAddress() { return ipAddress; }
//     public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

//     public String getDeviceId() { return deviceId; }
//     public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

//     public String getLocation() { return location; }
//     public void setLocation(String location) { this.location = location; }

//     public LocalDateTime getTimestamp() { return timestamp; }
//     public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
// }
