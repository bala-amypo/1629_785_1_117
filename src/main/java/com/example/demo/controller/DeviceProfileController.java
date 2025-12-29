package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Optional;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
@SecurityRequirement(name="BearerAuth")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device){
        return deviceService.registerDevice(device);
    }

    @GetMapping("/{id}")
    public Optional<DeviceProfile> lookup(@PathVariable String id){
        return deviceService.findByDeviceId(id);
    }
}



// package com.example.demo.controller;

// import com.example.demo.entity.*;
// import com.example.demo.service.*;
// import org.springframework.http.*;

// public class DeviceProfileController {
//     private final DeviceProfileService service;
//     public DeviceProfileController(DeviceProfileService service) {
//         this.service = service;
//     }
//     public ResponseEntity<DeviceProfile> lookup(String id) {
//         return ResponseEntity.ok(service.findByDeviceId(id).orElse(null));
//     }
// }
