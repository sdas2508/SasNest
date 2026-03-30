package com.propertybuy.rentu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.propertybuy.rentu.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserMobileNumber(String userMobileNumber);
    User findByUserEmail(String userEmail);
}
