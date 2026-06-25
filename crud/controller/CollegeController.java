package com.example.crud.controller;

import com.example.crud.dto.CollegeDTO;
import com.example.crud.entity.College;
import com.example.crud.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService service;

    @PostMapping("/create")
    public ResponseEntity<College> createCollege(@RequestBody CollegeDTO dto) {
        College college = service.createCollege(dto);
        return new ResponseEntity<>(college, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<College>> getAllColleges() {
        List<College> colleges = service.getAllColleges();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Integer id) {
        College college = service.getCollegeById(id);
        return new ResponseEntity<>(college, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Integer id, @RequestBody CollegeDTO dto) {
        College college = service.updateCollege(id, dto);
        return new ResponseEntity<>(college, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteCollege(@PathVariable Integer id) {
        service.deleteCollege(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "College deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}