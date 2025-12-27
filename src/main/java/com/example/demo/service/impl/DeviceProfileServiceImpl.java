// package com.example.demo.service.impl;

// import com.example.demo.entity.DeviceProfile;
// import com.example.demo.repository.DeviceProfileRepository;
// import com.example.demo.service.DeviceProfileService;

// import java.util.List;
// import java.util.Optional;
// import org.springframework.stereotype.Service;
// @Service
// public class DeviceProfileServiceImpl implements DeviceProfileService {

//     private DeviceProfileRepository repo;

//     public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
//         this.repo = repo;
//     }
//   @Override
//     public DeviceProfile registerDevice(DeviceProfile d) {
//         return repo.save(d);
//     }
//   @Override
//     public DeviceProfile updateTrustStatus(Long id, boolean trust) {
//         DeviceProfile d = repo.findById(id).orElseThrow();
//         d.setIsTrusted(trust);
//         return repo.save(d);
//     }
//   @Override
//     public List<DeviceProfile> getDevicesByUser(Long userId) {
//         return repo.findByUserId(userId);
//     }
//   @Override
//     public Optional<DeviceProfile> findByDeviceId(String deviceId) {
//         return repo.findByDeviceId(deviceId);
//     }
// }


// package com.example.demo.service.impl;

// import com.example.demo.entity.DeviceProfile;
// import com.example.demo.repository.DeviceProfileRepository;
// import com.example.demo.service.DeviceProfileService;

// import java.util.List;
// import java.util.Optional;
// import org.springframework.stereotype.Service;
// @Service
// public class DeviceProfileServiceImpl implements DeviceProfileService {

//     private final DeviceProfileRepository deviceRepo;

//     public DeviceProfileServiceImpl(DeviceProfileRepository deviceRepo) {
//         this.deviceRepo = deviceRepo;
//     }

//     @Override
//     public DeviceProfile registerDevice(DeviceProfile device) {
//         return deviceRepo.save(device);
//     }

//     @Override
//     public DeviceProfile updateTrustStatus(Long id, boolean trust) {
//         DeviceProfile device = deviceRepo.findById(id).orElseThrow();
//         device.setIsTrusted(trust);
//         return deviceRepo.save(device);
//     }

//     @Override
//     public List<DeviceProfile> getDevicesByUser(Long userId) {
//         return deviceRepo.findByUserId(userId);
//     }

//     @Override
//     public Optional<DeviceProfile> findByDeviceId(String deviceId) {
//         return deviceRepo.findByDeviceId(deviceId);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import java.util.*;

public class DeviceProfileServiceImpl implements DeviceProfileService {
    private final DeviceProfileRepository repo;
    public DeviceProfileServiceImpl(DeviceProfileRepository repo) { this.repo = repo; }

    public DeviceProfile registerDevice(DeviceProfile d) { return repo.save(d); }
    public Optional<DeviceProfile> findByDeviceId(String id) { return repo.findByDeviceId(id); }
    public DeviceProfile updateTrustStatus(Long id, Boolean trusted) {
        DeviceProfile d = repo.findById(id).orElse(null);
        d.setIsTrusted(trusted);
        return repo.save(d);
    }
}
