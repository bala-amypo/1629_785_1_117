package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
// @RequestMapping("/api/rules")
// public class PolicyRuleController {

//     private final PolicyRuleService service;

//     public PolicyRuleController(PolicyRuleService service) {
//         this.service = service;
//     }

//     @PostMapping("/")
//     public PolicyRule create(@RequestBody PolicyRule rule) {
//         return service.createRule(rule);
//     }

//     @PutMapping("/{id}")
//     public PolicyRule update(@PathVariable Long id,@RequestBody PolicyRule rule) {
//         return service.updateRule(id, rule);
//     }

//     @GetMapping("/active")
//     public List<PolicyRule> active() {
//         return service.getActiveRules();
//     }

//     @GetMapping("/")
//     public List<PolicyRule> all() {
//         return service.getAllRules();
//     }
// }
@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping("/")
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return service.registerDevice(device);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile trust(@PathVariable Long id,
                               @RequestBody Boolean trust) {
        return service.updateTrustStatus(id, trust);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> byUser(@PathVariable Long userId) {
        return service.getDevicesByUser(userId);
    }

    @GetMapping("/lookup/{deviceId}")
    public DeviceProfile lookup(@PathVariable String deviceId) {
        return service.findByDeviceId(deviceId);
    }
}
