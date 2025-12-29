package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository violationRepo;
    private final UserAccountRepository userRepo;

    @Override
    public ViolationRecord logViolation(Long userId, ViolationRecord record) {

        UserAccount user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        record.setUser(user);              // link user
        record.setTimestamp(LocalDateTime.now());
        record.setStatus("UNRESOLVED");    // default

        return violationRepo.save(record);
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return violationRepo.findByUserId(userId);
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord v = violationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Violation not found"));

        v.setStatus("RESOLVED");
        return violationRepo.save(v);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByStatus("UNRESOLVED");
    }
}























// package com.example.demo.service.impl;

// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.repository.ViolationRecordRepository;
// import com.example.demo.service.ViolationRecordService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// @RequiredArgsConstructor
// public class ViolationRecordServiceImpl implements ViolationRecordService {

//     private final ViolationRecordRepository violationRepo;

//     @Override
//     public ViolationRecord logViolation(ViolationRecord v) {
//         return violationRepo.save(v);
//     }

//     @Override
//     public List<ViolationRecord> getUnresolvedViolations() {
//         return violationRepo.findByResolvedFalse();
//     }

//     @Override
//     public ViolationRecord markResolved(Long id) {
//         ViolationRecord record = violationRepo.findById(id).orElse(null);
//         if(record == null) return null;

//         record.setResolved(true);
//         return violationRepo.save(record);
//     }
// }
