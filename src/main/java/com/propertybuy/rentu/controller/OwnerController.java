package com.propertybuy.rentu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.propertybuy.rentu.entity.Owner;
import com.propertybuy.rentu.repository.OwnerRepository;
import com.propertybuy.rentu.dto.PropertyOwnerData;

@RestController
@RequestMapping("/api/owner")
@CrossOrigin
public class OwnerController {

    private final OwnerRepository ownerRepo;

    public OwnerController(OwnerRepository ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    // ================= REGISTER OWNER =================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Owner owner) {
        if (ownerRepo.findByOwnerMobileNumber(owner.getOwnerMobileNumber()) != null) {
            return ResponseEntity.badRequest().body("Owner already exists");
        }
        ownerRepo.save(owner);
        return ResponseEntity.status(201).body("Owner registered successfully");
    }

    // ================= LOGIN OWNER =================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Owner owner) {
        Owner existing = ownerRepo.findByOwnerEmail(owner.getOwnerEmail());
        if (existing == null) return ResponseEntity.status(404).body("Owner not found");
        if (!existing.getOwnerPassword().equals(owner.getOwnerPassword()))
            return ResponseEntity.status(401).body("Invalid password");

        PropertyOwnerData dto = new PropertyOwnerData(
            existing.getId(),
            existing.getOwnerName(),
            existing.getOwnerEmail(),
            existing.getOwnerMobileNumber()
        );

        return ResponseEntity.ok(dto);
    }

    // ================= GET OWNER BY ID (for Contact Owner) =================
    @GetMapping("/{id}")
    public ResponseEntity<?> getOwnerById(@PathVariable Long id) {
        return ownerRepo.findById(id)
                .map(owner -> new PropertyOwnerData(
                        owner.getId(),
                        owner.getOwnerName(),
                        owner.getOwnerEmail(),
                        owner.getOwnerMobileNumber()
                ))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
