package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/violations")
@RequiredArgsConstructor
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




// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.service.ViolationRecordService;
// import org.springframework.web.bind.annotation.*;
// import lombok.RequiredArgsConstructor;
// import java.util.List;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/violations")
// @RequiredArgsConstructor
// @SecurityRequirement(name="BearerAuth")
// public class ViolationRecordController {

//     private final ViolationRecordService violationService;

//     @PostMapping
//     public ViolationRecord log(@RequestBody ViolationRecord v){
//         return violationService.logViolation(v);
//     }

//     @GetMapping("/unresolved")
//     public List<ViolationRecord> unresolved(){
//         return violationService.getUnresolvedViolations();
//     }

//     @PutMapping("/{id}/resolve")
//     public ViolationRecord resolve(@PathVariable Long id){
//         return violationService.markResolved(id);
//     }
// }
