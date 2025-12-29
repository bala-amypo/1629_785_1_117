package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private String deviceType;
    private String osVersion;

    private Boolean isTrusted = false;   // ← REQUIRED FIELD (Fix for build error)

    @ManyToOne
    @JoinColumn(name = "user_id")        // Only one mapping to avoid duplicate column issue
    private UserAccount user;
}





















