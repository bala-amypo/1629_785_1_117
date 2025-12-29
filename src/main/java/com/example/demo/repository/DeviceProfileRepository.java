// package com.example.demo.repository;

// import com.example.demo.entity.DeviceProfile;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
//     Optional<DeviceProfile> findByDeviceId(String deviceId);   // REQUIRED BY TESTCASE #13 & #26
// }









package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;
public interface DeviceProfileRepository {
    DeviceProfile save(DeviceProfile d);
    Optional<DeviceProfile> findById(Long id);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
