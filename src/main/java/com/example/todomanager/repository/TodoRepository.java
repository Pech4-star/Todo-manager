package com.example.todomanager.repository;

import com.example.todomanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}