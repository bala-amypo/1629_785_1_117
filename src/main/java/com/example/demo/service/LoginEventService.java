package com.example.demo.service;

import com.example.demo.entity.LoginEvent;

import java.util.List;

public interface LoginEventService {

    LoginEvent recordLogin(LoginEvent event);

    List<LoginEvent> getEventsByUser(Long userId);

    List<LoginEvent> getSuspiciousLogins(Long userId);

    List<LoginEvent> getAllEvents();
}
package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;

import java.util.List;
import java.util.Optional;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);

    DeviceProfile updateTrustStatus(Long id, boolean trust);

    List<DeviceProfile> getDevicesByUser(Long userId);

    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
package com.example.demo.service;

import com.example.demo.entity.PolicyRule;

import java.util.List;

public interface PolicyRuleService {

    PolicyRule createRule(PolicyRule rule);

    PolicyRule updateRule(Long id, PolicyRule rule);

    List<PolicyRule> getActiveRules();

    PolicyRule getRuleByCode(String ruleCode);

    List<PolicyRule> getAllRules();
}
package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;

import java.util.List;

public interface ViolationRecordService {

    ViolationRecord logViolation(ViolationRecord violation);

    List<ViolationRecord> getViolationsByUser(Long userId);

    ViolationRecord markResolved(Long id);

    List<ViolationRecord> getUnresolvedViolations();

    List<ViolationRecord> getAllViolations();
}