package com.example.crud.controller;

import com.example.crud.dto.StudentDTO;
import com.example.crud.entity.Student;
import com.example.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/save-user")
    public ResponseEntity<Student> createStudentUser(@RequestBody StudentDTO dto) {
        Student student = service.createStudentUser(dto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PostMapping("/save-enquiry")
    public ResponseEntity<Student> createStudentEnquiry(@RequestBody StudentDTO dto) {
        Student student = service.createStudentEnquiry(dto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<Student> getStudentUserById(@PathVariable Integer id) {
        Student student = service.getStudentUserById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/get-enquiry/{id}")
    public ResponseEntity<Student> getStudentEnquiryById(@PathVariable Integer id) {
        Student student = service.getStudentEnquiryById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO dto) {
        Student student = service.updateStudent(id, dto);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Student deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Student>> getStudentsByDepartment(@PathVariable String department) {
        List<Student> students = service.getStudentsByDepartment(department);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}