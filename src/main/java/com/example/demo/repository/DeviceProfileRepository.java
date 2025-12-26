package com.example.demo.repository;

import com.example.demo.entity.DeviceProfile;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
    List<DeviceProfile> findByUserId(Long userId);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
