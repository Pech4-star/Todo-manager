package com.example.todomanager.controller;

import com.example.todomanager.model.user;
import com.example.todomanager.service.userService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class userController { // identify the class of user controller

    private final userService service;

    public userController(userService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("tasks", service.getAllTasks());
        model.addAttribute("task", new user());
        return "index";
    }

    @PostMapping("/save")
    public String saveTask(user user) {
        service.saveTask(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "redirect:/";
    }
}

