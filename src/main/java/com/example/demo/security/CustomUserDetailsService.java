// package com.example.demo.security;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.repository.UserAccountRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.security.core.userdetails.*;
// import org.springframework.stereotype.Service;

// @Service
// @RequiredArgsConstructor
// public class CustomUserDetailsService implements UserDetailsService {

//     private final UserAccountRepository repo;

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//         UserAccount user = repo.findByEmail(email)
//                 .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

//         return org.springframework.security.core.userdetails.User
//                 .withUsername(user.getEmail())
//                 .password(user.getPassword())
//                 .roles(user.getRole())
//                 .build();
//     }
// }
