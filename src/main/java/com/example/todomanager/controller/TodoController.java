package com.example.todomanager.controller;

import com.example.todomanager.model.User;
import com.example.todomanager.model.Todo;
import com.example.todomanager.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {

    private final TodoRepository TodoRepository;

    public TodoController(TodoRepository userRepository) {
        this.TodoRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/todos")
    public String todos(Model model) {
        List<User> users = TodoRepository.findAll();
        model.addAttribute("users", users);
        return "todos";
    }

    @PostMapping("/todos")
    public String addTodo(@RequestParam String title, Model model) {
        return "redirect:/todos";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}