package com.propertybuy.rentu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.propertybuy.rentu.entity.Property;
import com.propertybuy.rentu.dto.PropertyOwnerData;
import com.propertybuy.rentu.repository.PropertyRepository;
import java.util.Optional;

@RestController
@RequestMapping("/api/owners") // match with your JS fetch URL
@CrossOrigin
public class PropertyController {

    private final PropertyRepository propertyRepo;

    public PropertyController(PropertyRepository propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    // GET owner by property ID
    @GetMapping("/{id}")
    public ResponseEntity<PropertyOwnerData> getOwnerById(@PathVariable Long id) {
        Optional<Property> optionalProperty = propertyRepo.findById(id);

        if (optionalProperty.isPresent()) {
            Property p = optionalProperty.get();
            PropertyOwnerData dto = new PropertyOwnerData(
                    p.getId(),
                    p.getOwnerName(),
                    p.getOwnerEmail(),
                    p.getOwnerMobileNumber()
            );
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
