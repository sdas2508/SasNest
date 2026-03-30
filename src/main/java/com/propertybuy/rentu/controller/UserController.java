package com.propertybuy.rentu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.propertybuy.rentu.entity.User;
import com.propertybuy.rentu.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // ================= REGISTER USER =================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        if (userRepo.findByUserMobileNumber(user.getUserMobileNumber()) != null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("User already exists");
        }

        User saved = userRepo.save(user);
        saved.setUserPassword(null); // 🔒 hide password
        return ResponseEntity.ok(saved);
    }

    // ================= LOGIN USER =================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User existing = userRepo.findByUserEmail(user.getUserEmail());

        if (existing == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }

        if (!existing.getUserPassword().equals(user.getUserPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid password");
        }

        existing.setUserPassword(null); // 🔒 hide password
        return ResponseEntity.ok(existing);
    }

    // ================= GET USER BY ID =================
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setUserPassword(null);
                    return ResponseEntity.ok(user);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
