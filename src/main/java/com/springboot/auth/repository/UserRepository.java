package com.springboot.auth.repository;

import com.springboot.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByMobileOrEmail(String mobile, String email);

    Optional<User> findByMobile(String mobile);

    Boolean existsByMobile(String mobile);

    Boolean existsByEmail(String email);
}
