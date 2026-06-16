package com.example.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserE {

    @Id
    private int id;
    private String name;

    public UserE() {
    }

    public UserE(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}