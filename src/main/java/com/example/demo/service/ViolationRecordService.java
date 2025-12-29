package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import java.util.List;

public interface ViolationRecordService {

    ViolationRecord logViolation(ViolationRecord record);  // single object accepted

    List<ViolationRecord> getViolationsByUser(Long userId);

    ViolationRecord markResolved(Long id);

    List<ViolationRecord> getUnresolvedViolations();
}






// package com.example.demo.service;

// import com.example.demo.entity.ViolationRecord;
// import java.util.List;

// public interface ViolationRecordService {

//     ViolationRecord logViolation(Long userId, ViolationRecord record);

//     List<ViolationRecord> getViolationsByUser(Long userId);

//     ViolationRecord markResolved(Long id);

//     List<ViolationRecord> getUnresolvedViolations();
// }




























// // package com.example.demo.service;

// // import com.example.demo.entity.ViolationRecord;
// // import java.util.List;

// // public interface ViolationRecordService {
// //     ViolationRecord logViolation(ViolationRecord v);
// //     List<ViolationRecord> getUnresolvedViolations();
// //     ViolationRecord markResolved(Long id);
// // }
