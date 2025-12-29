// package com.example.demo.service.impl;

// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.repository.ViolationRecordRepository;
// import com.example.demo.service.ViolationRecordService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// @RequiredArgsConstructor
// public class ViolationRecordServiceImpl implements ViolationRecordService {

//     private final ViolationRecordRepository repo;

//     @Override
//     public ViolationRecord logViolation(ViolationRecord v){
//         v.setTimestamp(LocalDateTime.now());
//         return repo.save(v);
//     }

//     @Override
//     public List<ViolationRecord> getUnresolvedViolations(){
//         return repo.findByResolvedFalse();
//     }

//     @Override
//     public ViolationRecord markResolved(Long id){
//         ViolationRecord v = repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Violation Not Found"));
//         v.setResolved(true);
//         return repo.save(v);
//     }
// }







package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import java.util.*;

public class ViolationRecordServiceImpl implements ViolationRecordService {
    private final ViolationRecordRepository repo;
    public ViolationRecordServiceImpl(ViolationRecordRepository repo) { this.repo = repo; }

    public ViolationRecord logViolation(ViolationRecord v) { return repo.save(v); }
    public List<ViolationRecord> getUnresolvedViolations() { return repo.findByResolvedFalse(); }
    public ViolationRecord markResolved(Long id) {
        ViolationRecord v = repo.findById(id).orElse(null);
        v.setResolved(true);
        return repo.save(v);
    }
}
