// package com.example.demo.service.impl;

// import com.example.demo.entity.DeviceProfile;
// import com.example.demo.repository.DeviceProfileRepository;
// import com.example.demo.service.DeviceProfileService;
// import com.example.demo.exception.BadRequestException;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class DeviceProfileServiceImpl implements DeviceProfileService {

//     private DeviceProfileRepository deviceRepo;

//     public DeviceProfileServiceImpl(DeviceProfileRepository deviceRepo) {
//         this.deviceRepo = deviceRepo;
//     }

//     @Override
//     public DeviceProfile registerDevice(DeviceProfile device) {
//         return deviceRepo.save(device);
//     }

//     @Override
//     public DeviceProfile updateTrustStatus(Long id, boolean trust) {
//         DeviceProfile device = deviceRepo.findById(id)
//                 .orElseThrow(() -> new BadRequestException("Device not found"));
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

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Device not found"));
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Device not found"));

        device.setIsTrusted(trust);
        return repo.save(device);
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setIsTrusted(false);
        return repo.save(device);
    }
}
