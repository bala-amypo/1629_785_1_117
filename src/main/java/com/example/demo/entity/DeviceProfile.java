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






// package com.example.demo.entity;

// import java.time.LocalDateTime;

// public class DeviceProfile {
//     private Long id;
//     private Long userId;
//     private String deviceId;
//     private String deviceType;
//     private String osVersion;
//     private Boolean isTrusted;
//     private LocalDateTime lastSeen;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getUserId() { return userId; }
//     public void setUserId(Long userId) { this.userId = userId; }

//     public String getDeviceId() { return deviceId; }
//     public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

//     public String getDeviceType() { return deviceType; }
//     public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

//     public String getOsVersion() { return osVersion; }
//     public void setOsVersion(String osVersion) { this.osVersion = osVersion; }

//     public Boolean getIsTrusted() { return isTrusted; }
//     public void setIsTrusted(Boolean trusted) { isTrusted = trusted; }

//     public LocalDateTime getLastSeen() { return lastSeen; }
//     public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; }
// }
















