package com.example.crud.service;

import com.example.crud.entity.UserE;
import com.example.crud.repository.UserR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserS {

    @Autowired
    private UserR repo;

    public List<UserE> getAllUsers() {
        return repo.findAll();
    }

    public UserE addUser(UserE user) {
        return repo.save(user);
    }

    public UserE updateUser(UserE user) {
        return repo.save(user);
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }
}