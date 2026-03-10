package com.example.todomanager.service;

import com.example.todomanager.model.user;
import com.example.todomanager.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    private final TodoRepository repository;

    public userService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<user> getAllTasks() {
        return repository.findAll();
    }

    public void saveTask(user user) {
        repository.save(user);
    }

    public void deleteTask(Long id) {
    }
}