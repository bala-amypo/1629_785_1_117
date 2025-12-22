// package com.example.demo.controller;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.service.UserAccountService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/users")
// public class UserAccountController {

//     private final UserAccountService service;

//     public UserAccountController(UserAccountService service) {
//         this.service = serviace;
//     }

//     @PostMapping("/")
//     public UserAccount create(@RequestBody UserAccount user) {
//         return service.createUser(user);
//     }

//     @GetMapping("/{id}")
//     public UserAccount get(@PathVariable Long id) {
//         return service.getUserById(id);
//     }

//     @PutMapping("/{id}/status")
//     public UserAccount update(@PathVariable Long id,@RequestBody String status) {
//         return service.updateUserStatus(id, status);
//     }

//     @GetMapping("/")
//     public List<UserAccount> all() {
//         return service.getAllUsers();
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.entity.AccountStatus;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/")
    public UserAccount create(@RequestBody UserAccount user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount get(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}/status")
    public UserAccount update(@PathVariable Long id,@RequestParam AccountStatus status) {
        return service.updateUserStatus(id, status);
    }

    @GetMapping("/")
    public List<UserAccount> all() {
        return service.getAllUsers();
    }
}
