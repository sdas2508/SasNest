package com.propertybuy.rentu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.propertybuy.rentu.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByOwnerMobileNumber(String ownerMobileNumber);
    Owner findByOwnerEmail(String ownerEmail);
}
