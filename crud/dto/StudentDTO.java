package com.example.crud.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String name;
    private Integer age;
    private String mobile;
    private String email;
    private Integer departmentId;
    private boolean passedOut;
}