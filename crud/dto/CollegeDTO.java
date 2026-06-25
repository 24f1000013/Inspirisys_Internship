package com.example.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeDTO {
    private String collegeName;
    private String location;
    private String contactNumber;
    private String email;
}
