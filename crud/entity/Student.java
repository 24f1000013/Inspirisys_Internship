package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String name;
    private Integer age;
    private String mobile;
    private String email;
    private boolean passedOut;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference("department-student")
    private Department department;
}