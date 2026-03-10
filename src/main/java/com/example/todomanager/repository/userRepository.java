package com.example.todomanager.repository;

import com.example.todomanager.model.user;
import com.example.todomanager.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface userRepository extends JpaRepository<user, Long> {
    user findByUsername(String username);
}