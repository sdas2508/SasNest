package com.propertybuy.rentu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.propertybuy.rentu.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findByOwnerEmail(String ownerEmail);
    Property findByOwnerMobileNumber(String ownerMobileNumber);
}
