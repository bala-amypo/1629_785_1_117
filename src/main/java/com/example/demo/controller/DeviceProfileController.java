package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;

public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    public ResponseEntity<DeviceProfile> lookup(String deviceId) {
        return ResponseEntity.ok(service.findByDeviceId(deviceId).orElse(null));
    }
}
