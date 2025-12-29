// package com.example.demo.controller;

// import com.example.demo.entity.PolicyRule;
// import com.example.demo.service.PolicyRuleService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.*;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;

// import java.util.List;

// @RestController
// @RequestMapping("/rules")
// @RequiredArgsConstructor
// @SecurityRequirement(name = "BearerAuth")   // 🔒
// public class PolicyRuleController {

//     private final PolicyRuleService ruleService;

//     @PostMapping("/create")
//     public PolicyRule create(@RequestBody PolicyRule rule){
//         return ruleService.createRule(rule);
//     }

//     @GetMapping("/all")
//     public List<PolicyRule> all(){
//         return ruleService.getAllRules();
//     }

//     @GetMapping("/active")
//     public List<PolicyRule> active(){
//         return ruleService.getActiveRules();
//     }
// }


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
