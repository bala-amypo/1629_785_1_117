package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder encoder;

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setPassword(encoder.encode(user.getPassword())); // password hashing for real use
        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = userRepo.findById(id).orElse(null);
        if(user == null) return null;

        user.setStatus(status);
        return userRepo.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }
}
