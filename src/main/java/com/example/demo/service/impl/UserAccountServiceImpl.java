package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public UserAccount createUser(UserAccount user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getStatus() == null) user.setStatus("ACTIVE");
        user.setCreatedAt(LocalDateTime.now());
        return userRepo.save(user);
    }

    public UserAccount getUserById(Long id) {
        return userRepo.findById(id).orElseThrow();
    }

    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount u = getUserById(id);
        u.setStatus(status);
        return userRepo.save(u);
    }

    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }
}
