package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long policyRuleId;
    private Long eventId;
    private String violationType;
    private String details;
    private String severity;
    private LocalDateTime detectedAt;
    private Boolean resolved;
}
