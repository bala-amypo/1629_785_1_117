// package com.example.demo.service;

// import com.example.demo.entity.DeviceProfile;
// import java.util.*;

// public interface DeviceProfileService {
//     DeviceProfile registerDevice(DeviceProfile device);
//     DeviceProfile updateTrustStatus(Long id, boolean trust);
//     List<DeviceProfile> getDevicesByUser(Long userId);
//     Optional<DeviceProfile> findByDeviceId(String deviceId);
// }
package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;
public interface DeviceProfileService {
    DeviceProfile registerDevice(DeviceProfile d);
    Optional<DeviceProfile> findByDeviceId(String id);
    DeviceProfile updateTrustStatus(Long id, Boolean trusted);
}
