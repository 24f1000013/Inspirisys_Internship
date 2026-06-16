package com.example.crud.repository;

import com.example.crud.entity.UserE;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserR extends JpaRepository<UserE, Integer> {
}
