package com.example.crud.controller;

import com.example.crud.entity.UserE;
import com.example.crud.service.UserS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserC {

    @Autowired
    private UserS service;

    @GetMapping
    public List<UserE> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public UserE addUser(@RequestBody UserE user) {
        return service.addUser(user);
    }

    @PutMapping
    public UserE updateUser(@RequestBody UserE user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return "User deleted";
    }
}