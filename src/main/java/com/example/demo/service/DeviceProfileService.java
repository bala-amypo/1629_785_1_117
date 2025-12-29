package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.Optional;

public interface DeviceProfileService {
    DeviceProfile registerDevice(DeviceProfile device);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
    DeviceProfile updateTrustStatus(Long id, boolean isTrusted);
}







// package com.example.demo.service;

// import com.example.demo.entity.*;
// import java.util.*;
// public interface DeviceProfileService {
//     DeviceProfile registerDevice(DeviceProfile d);
//     Optional<DeviceProfile> findByDeviceId(String id);
//     DeviceProfile updateTrustStatus(Long id, Boolean trusted);
// }
