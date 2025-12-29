package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "violation_record")
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference   // prevents circular serialization
    private UserAccount user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @JsonBackReference   // prevents recursion with LoginEvent
    private LoginEvent event;

    private String details;
    private String severity;
    private boolean resolved = false;

    private LocalDateTime timestamp = LocalDateTime.now(); // auto assigns timestamp
}


























































// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;
// import java.time.LocalDateTime;

// @Entity
// @Getter @Setter
// public class ViolationRecord {

//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private UserAccount user;

//     @ManyToOne
//     @JoinColumn(name = "event_id")
    
//     private LoginEvent event;

//     private String details;
//     private String severity;
//     private boolean resolved = false;
//     private LocalDateTime timestamp;
// }
