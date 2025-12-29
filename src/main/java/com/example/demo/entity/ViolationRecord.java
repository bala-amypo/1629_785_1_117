package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class ViolationRecord {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private LoginEvent event;

    private String details;
    private String severity;
    private boolean resolved = false;
    private LocalDateTime timestamp;
}







// package com.example.demo.entity;

// public class ViolationRecord {
//     private Long id;
//     private Long userId;
//     private Long eventId;
//     private String severity;
//     private String details;
//     private Boolean resolved = false;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getUserId() { return userId; }
//     public void setUserId(Long userId) { this.userId = userId; }

//     public Long getEventId() { return eventId; }
//     public void setEventId(Long eventId) { this.eventId = eventId; }

//     public String getSeverity() { return severity; }
//     public void setSeverity(String severity) { this.severity = severity; }

//     public String getDetails() { return details; }
//     public void setDetails(String details) { this.details = details; }

//     public Boolean getResolved() { return resolved; }
//     public void setResolved(Boolean resolved) { this.resolved = resolved; }
// }
