package com.spartamini9.pet9.repository;

import com.spartamini9.pet9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String user);

    Optional<User> findByEmail(String email);
}
