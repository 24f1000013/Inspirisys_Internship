package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer collegeId;

    private String collegeName;
    private String location;
    private String contactNumber;
    private String email;

    @OneToMany(mappedBy = "college",cascade = CascadeType.ALL)
    @JsonManagedReference("college-department")
    private List<Department> departments;
}