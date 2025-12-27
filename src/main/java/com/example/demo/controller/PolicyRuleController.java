// // package com.example.demo.controller;

// // import com.example.demo.entity.PolicyRule;
// // import com.example.demo.service.PolicyRuleService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/api/rules")
// // public class PolicyRuleController {

// //     private final PolicyRuleService service;

// //     public PolicyRuleController(PolicyRuleService service) {
// //         this.service = service;
// //     }

// //     @PostMapping
// //     public PolicyRule createRule(@RequestBody PolicyRule rule) {
// //         return service.createRule(rule);
// //     }

// //     @PutMapping("/{id}")
// //     public PolicyRule updateRule(
// //             @PathVariable Long id,
// //             @RequestBody PolicyRule rule) {
// //         return service.updateRule(id, rule);
// //     }

// //     @GetMapping("/active")
// //     public List<PolicyRule> getActiveRules() {
// //         return service.getActiveRules();
// //     }

// //     @GetMapping
// //     public List<PolicyRule> getAllRules() {
// //         return service.getAllRules();
// //     }
// // }

package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.http.*;

public class PolicyRuleController {
    private final PolicyRuleService service;
    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }
    public ResponseEntity<java.util.List<PolicyRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }
}
