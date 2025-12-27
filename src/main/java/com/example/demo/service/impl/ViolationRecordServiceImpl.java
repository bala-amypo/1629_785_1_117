// package com.example.demo.service.impl;

// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.repository.ViolationRecordRepository;
// import com.example.demo.service.ViolationRecordService;

// import java.util.List;
// import org.springframework.stereotype.Service;
// @Service
// public class ViolationRecordServiceImpl implements ViolationRecordService {

//     private ViolationRecordRepository repo;

//     public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
//         this.repo = repo;
//     }
//   @Override
//     public ViolationRecord logViolation(ViolationRecord v) {
//         return repo.save(v);
//     }
//   @Override
//     public List<ViolationRecord> getViolationsByUser(Long userId) {
//         return repo.findByUserId(userId);
//     }
//   @Override
//     public ViolationRecord markResolved(Long id) {
//         ViolationRecord v = repo.findById(id).orElseThrow();
//         v.setResolved(true);
//         return repo.save(v);
//     }
//   @Override
//     public List<ViolationRecord> getUnresolvedViolations() {
//         return repo.findByResolvedFalse();
//     }
//   @Override
//     public List<ViolationRecord> getAllViolations() {
//         return repo.findAll();
//     }
// }


// // package com.example.demo.service.impl;

// // import com.example.demo.entity.ViolationRecord;
// // import com.example.demo.repository.ViolationRecordRepository;
// // import com.example.demo.service.ViolationRecordService;

// // import java.util.List;
// // import org.springframework.stereotype.Service;

// // @Service

// // public class ViolationRecordServiceImpl implements ViolationRecordService {

// //     private final ViolationRecordRepository violationRepo;

// //     public ViolationRecordServiceImpl(ViolationRecordRepository violationRepo) {
// //         this.violationRepo = violationRepo;
// //     }

// //     @Override
// //     public ViolationRecord logViolation(ViolationRecord violation) {
// //         return violationRepo.save(violation);
// //     }

// //     @Override
// //     public List<ViolationRecord> getViolationsByUser(Long userId) {
// //         return violationRepo.findByUserId(userId);
// //     }

// //     @Override
// //     public ViolationRecord markResolved(Long id) {
// //         ViolationRecord record = violationRepo.findById(id).orElseThrow();
// //         record.setResolved(true);
// //         return violationRepo.save(record);
// //     }

// //     @Override
// //     public List<ViolationRecord> getUnresolvedViolations() {
// //         return violationRepo.findByResolvedFalse();
// //     }

// //     @Override
// //     public List<ViolationRecord> getAllViolations() {
// //         return violationRepo.findAll();
// //     }
// // }
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
