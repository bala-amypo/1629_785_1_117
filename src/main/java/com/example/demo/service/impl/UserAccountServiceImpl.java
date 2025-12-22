package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import com.example.demo.exception.BadRequestException;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userRepo;

    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount createUser(UserAccount user) {

        if (user.getStatus() == null) {
            user.setStatus("ACTIVE");
        }

        user.setCreatedAt(LocalDateTime.now());
        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new BadRequestException("User not found"));
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = getUserById(id);
        user.setStatus(status);
        return userRepo.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
