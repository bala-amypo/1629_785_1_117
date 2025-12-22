package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
// import jakarta.validation.constraints.NotBlank;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "device_profiles")
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    // @NotBlank(message = "deviceId cannot be empty")
    private String deviceId;
    private String deviceType;
    private String osVersion;
    private LocalDateTime lastSeen;
    private Boolean isTrusted;

    @PrePersist
    protected void onCreate() {
        this.lastSeen = LocalDateTime.now();
    }
}
