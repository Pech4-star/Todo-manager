package com.example.todomanager.service;

import com.example.todomanager.model.user;
import com.example.todomanager.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    private final userRepository repository;

    public userService(userRepository repository) {
        this.repository = repository;
    }

    public List<user> getAllTasks() {
        return repository.findAll();
    }

    public void saveTask(user user) {
        repository.save(user);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}