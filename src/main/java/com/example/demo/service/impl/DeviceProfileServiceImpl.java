package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceRepo;

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return deviceRepo.save(device);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return deviceRepo.findByDeviceId(deviceId);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean isTrusted) {
        DeviceProfile device = deviceRepo.findById(id).orElse(null);
        if(device == null) return null;

        device.setIsTrusted(isTrusted);
        return deviceRepo.save(device);
    }
}
