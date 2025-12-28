// package com.example.demo.controller;

// import com.example.demo.entity.DeviceProfile;
// import com.example.demo.service.DeviceProfileService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/devices")
// public class DeviceProfileController {

//     private final DeviceProfileService service;

//     public DeviceProfileController(DeviceProfileService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public DeviceProfile registerDevice(@RequestBody DeviceProfile device) {
//         return service.registerDevice(device);
//     }

//     @PutMapping("/{id}/trust")
//     public DeviceProfile updateTrust(
//             @PathVariable Long id,
//             @RequestParam boolean trust) {
//         return service.updateTrustStatus(id, trust);
//     }

//     @GetMapping("/user/{userId}")
//     public List<DeviceProfile> getDevicesByUser(@PathVariable Long userId) {
//         return service.getDevicesByUser(userId);
//     }

//     @GetMapping("/lookup/{deviceId}")
//     public DeviceProfile lookup(@PathVariable String deviceId) {
//         return service.findByDeviceId(deviceId).orElse(null);
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceProfileController {
    private final DeviceProfileService service;
    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }
    public ResponseEntity<DeviceProfile> lookup(String id) {
        return ResponseEntity.ok(service.findByDeviceId(id).orElse(null));
    }
}

