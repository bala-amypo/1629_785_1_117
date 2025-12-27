// package com.example.demo.service.impl;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.repository.UserAccountRepository;
// import com.example.demo.service.UserAccountService;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.stereotype.Service;
// @Service
// public class UserAccountServiceImpl implements UserAccountService {

//     private UserAccountRepository userRepo;
//     private PasswordEncoder encoder;

//     public UserAccountServiceImpl(UserAccountRepository userRepo,
//                                   PasswordEncoder encoder) {
//         this.userRepo = userRepo;
//         this.encoder = encoder;
//     }
//   @Override
//     public UserAccount createUser(UserAccount user) {
//         user.setPassword(encoder.encode(user.getPassword()));
//         if (user.getStatus() == null) user.setStatus("ACTIVE");
//         user.setCreatedAt(LocalDateTime.now());
//         return userRepo.save(user);
//     }
//   @Override
//     public UserAccount getUserById(Long id) {
//         return userRepo.findById(id).orElseThrow();
//     }
//   @Override
//     public UserAccount updateUserStatus(Long id, String status) {
//         UserAccount u = getUserById(id);
//         u.setStatus(status);
//         return userRepo.save(u);
//     }
//   @Override
//     public List<UserAccount> getAllUsers() {
//         return userRepo.findAll();
//     }
//   @Override
//     public Optional<UserAccount> findByUsername(String username) {
//         return userRepo.findByUsername(username);
//     }
// }


// // package com.example.demo.service.impl;

// // import com.example.demo.entity.UserAccount;
// // import com.example.demo.repository.UserAccountRepository;
// // import com.example.demo.service.UserAccountService;
// // import org.springframework.security.crypto.password.PasswordEncoder;

// // import java.time.LocalDateTime;
// // import java.util.List;
// // import java.util.Optional;
// // import org.springframework.stereotype.Service;

// // @Service

// // public class UserAccountServiceImpl implements UserAccountService {

// //     private final UserAccountRepository userRepo;
// //     private final PasswordEncoder passwordEncoder;

// //     public UserAccountServiceImpl(UserAccountRepository userRepo,
// //                                   PasswordEncoder passwordEncoder) {
// //         this.userRepo = userRepo;
// //         this.passwordEncoder = passwordEncoder;
// //     }

// //     @Override
// //     public UserAccount createUser(UserAccount user) {
// //         user.setPassword(passwordEncoder.encode(user.getPassword()));
// //         if (user.getStatus() == null) {
// //             user.setStatus("ACTIVE");
// //         }
// //         user.setCreatedAt(LocalDateTime.now());
// //         return userRepo.save(user);
// //     }

// //     @Override
// //     public UserAccount getUserById(Long id) {
// //         return userRepo.findById(id).orElseThrow();
// //     }

// //     @Override
// //     public UserAccount updateUserStatus(Long id, String status) {
// //         UserAccount user = getUserById(id);
// //         user.setStatus(status);
// //         return userRepo.save(user);
// //     }

// //     @Override
// //     public List<UserAccount> getAllUsers() {
// //         return userRepo.findAll();
// //     }

// //     @Override
// //     public Optional<UserAccount> findByUsername(String username) {
// //         return userRepo.findByUsername(username);
// //     }
// // }

package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import java.util.*;

public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository repo;
    public UserAccountServiceImpl(UserAccountRepository repo, Object encoder) {
        this.repo = repo;
    }
    public UserAccount createUser(UserAccount u) { return repo.save(u); }
    public UserAccount getUserById(Long id) { return repo.findById(id).orElse(null); }
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount u = repo.findById(id).orElse(null);
        u.setStatus(status);
        return repo.save(u);
    }
    public List<UserAccount> getAllUsers() { return repo.findAll(); }
}
