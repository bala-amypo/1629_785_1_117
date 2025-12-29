package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/violations")
@RequiredArgsConstructor
@SecurityRequirement(name = "BearerAuth")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    @PostMapping("/log")
    public ViolationRecord log(@RequestBody ViolationRecord v){
        return violationService.logViolation(v);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved(){
        return violationService.getUnresolvedViolations();
    }

    @PutMapping("/resolve/{id}")
    public ViolationRecord resolve(@PathVariable Long id){
        return violationService.markResolved(id);
    }
}


// package com.example.demo.controller;

// import com.example.demo.entity.*;
// import com.example.demo.service.*;
// import org.springframework.http.*;

// public class ViolationRecordController {
//     private final ViolationRecordService service;
//     public ViolationRecordController(ViolationRecordService service) {
//         this.service = service;
//     }
//     public ResponseEntity<ViolationRecord> log(ViolationRecord v) {
//         return ResponseEntity.ok(service.logViolation(v));
//     }
// }

