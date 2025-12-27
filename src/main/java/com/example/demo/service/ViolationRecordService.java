// package com.example.demo.service;

// import com.example.demo.entity.ViolationRecord;
// import java.util.*;

// public interface ViolationRecordService {
//     ViolationRecord logViolation(ViolationRecord violation);
//     List<ViolationRecord> getViolationsByUser(Long userId);
//     ViolationRecord markResolved(Long id);
//     List<ViolationRecord> getUnresolvedViolations();
//     List<ViolationRecord> getAllViolations();
// }

package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;
public interface ViolationRecordService {
    ViolationRecord logViolation(ViolationRecord v);
    List<ViolationRecord> getUnresolvedViolations();
    ViolationRecord markResolved(Long id);
}
