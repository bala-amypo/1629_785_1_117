// package com.example.demo.repository;

// import com.example.demo.entity.DeviceProfile;

// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.*;

// public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
//     List<DeviceProfile> findByUserId(Long userId);
//     Optional<DeviceProfile> findByDeviceId(String deviceId);
// }

package com.example.demo.repository;
// import com.example.demo.entity.*;
import com.example.demo.entity.DeviceProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface DeviceProfileRepository extends JpaRepository<DeviceProfile,Long> {
    DeviceProfile save(DeviceProfile d);
    Optional<DeviceProfile> findById(Long id);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
