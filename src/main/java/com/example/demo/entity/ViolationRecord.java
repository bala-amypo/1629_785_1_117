package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long eventId;
    private String details;
    private String severity;
    private Boolean resolved = false;

    // REQUIRED FOR RULE-EVALUATION UTIL & TEST SAFETY
    private LocalDateTime timestamp;

    // this method FIXES the compile error
    public void setTimestamp(LocalDateTime time){
        this.timestamp = time;
    }
}
















































// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

// @Entity
// @Getter @Setter
// public class ViolationRecord {

//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long userId;
//     private Long eventId;
//     private String details;
//     private String severity;
//     private Boolean resolved = false;
// }
