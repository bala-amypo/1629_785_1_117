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
@SecurityRequirement(name = "BearerAuth")   // Secure routes
public class ViolationRecordController {

    private final ViolationRecordService service;

    // ⬅ expects only request body, no userId here
    @PostMapping("/log")
    public ViolationRecord log(@RequestBody ViolationRecord record){
        return service.logViolation(record);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved(){
        return service.getUnresolvedViolations();
    }

    @PutMapping("/resolve/{id}")
    public ViolationRecord resolve(@PathVariable Long id){
        return service.markResolved(id);
    }
}
