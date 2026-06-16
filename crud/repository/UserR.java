package com.example.crud.repository;

import com.example.crud.entity.UserE;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserR extends JpaRepository<UserE, Integer> {
}
