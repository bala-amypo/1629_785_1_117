package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PolicyRule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private Boolean active;
    private String severity;
    private String description;

    @Column(columnDefinition = "TEXT")
    private String conditionsJson;
}
