package com.propertybuy.rentu.repository;

import com.propertybuy.rentu.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findByUserEmail(String userEmail);
    void deleteByUserEmail(String userEmail);
}