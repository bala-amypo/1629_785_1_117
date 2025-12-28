package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class LoginEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;                     // REQUIRED FOR TESTCASES
    private String ipAddress;
    private String deviceId;
    private String location;
    private String loginStatus;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserAccount user;                // keep relation safe
}


































// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;
// import java.time.LocalDateTime;

// @Entity
// @Getter @Setter
// public class LoginEvent {

//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String ipAddress;
//     private String deviceId;
//     private String location;
//     private String loginStatus;
//     private LocalDateTime timestamp;

//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private UserAccount user;
// }
