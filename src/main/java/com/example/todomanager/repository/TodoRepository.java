package com.example.todomanager.repository;

import com.example.todomanager.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends com.example.todomanager.repository.JpaRepository<user, Long> {
    user findByUsername(String username);

    List<user> findAll();

    void save(user user);
}