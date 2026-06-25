package com.example.crud.repository;

import com.example.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(
            value = "SELECT s.* FROM student s JOIN department d ON s.department_id = d.department_id WHERE d.department_name = ?1",
            nativeQuery = true
    )
    List<Student> getStudentsByDepartment(String department);
}