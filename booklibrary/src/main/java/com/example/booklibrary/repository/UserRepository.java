package com.example.booklibrary.repository;

import com.example.booklibrary.model.User_app;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User_app, Long> {
    Optional<User_app> findByUsername(String username);
    boolean existsByUsername(String username);
}
