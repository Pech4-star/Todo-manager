package com.example.todomanager.controller;

import com.example.todomanager.model.user;
import com.example.todomanager.repository.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoRepository TodoRepository;

    public TodoController(TodoRepository userRepository) {
        this.TodoRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "Hello, TodoManager!";
    }

    @GetMapping("/users")
    public List<user> getUsers() {
        return TodoRepository.findAll();
    }
}