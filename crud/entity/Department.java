package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    private String departmentName;
    private String hodName;

    @ManyToOne
    @JoinColumn(name = "college_id")
    @JsonBackReference("college-department")
    private College college;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference("department-student")
    private List<Student> students;
}