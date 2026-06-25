package com.example.crud.service;

import com.example.crud.dto.DepartmentDTO;
import com.example.crud.entity.College;
import com.example.crud.entity.Department;
import com.example.crud.exception.CollegeNotFoundException;
import com.example.crud.exception.DepartmentNotFoundException;
import com.example.crud.repository.CollegeRepository;
import com.example.crud.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private CollegeRepository collegeRepo;

    public Department createDepartment(DepartmentDTO dto) {
        try {
            College college = collegeRepo.findById(dto.getCollegeId())
                    .orElseThrow(() -> new CollegeNotFoundException("College ID not found in table"));

            Department department = new Department();
            department.setDepartmentName(dto.getDepartmentName());
            department.setHodName(dto.getHodName());
            department.setCollege(college);

            return departmentRepo.save(department);
        } catch (CollegeNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Department> getAllDepartments() {
        try {
            return departmentRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Department getDepartmentById(Integer id) {
        try {
            return departmentRepo.findById(id)
                    .orElseThrow(() -> new DepartmentNotFoundException("Department ID not found in table"));
        } catch (DepartmentNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Department updateDepartment(Integer id, DepartmentDTO dto) {
        try {
            Department department = departmentRepo.findById(id)
                    .orElseThrow(() -> new DepartmentNotFoundException("Department ID not found in table"));

            College college = collegeRepo.findById(dto.getCollegeId())
                    .orElseThrow(() -> new CollegeNotFoundException("College ID not found in table"));

            department.setDepartmentName(dto.getDepartmentName());
            department.setHodName(dto.getHodName());
            department.setCollege(college);

            return departmentRepo.save(department);
        } catch (DepartmentNotFoundException | CollegeNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteDepartment(Integer id) {
        try {
            Department department = departmentRepo.findById(id)
                    .orElseThrow(() -> new DepartmentNotFoundException("Department ID not found in table"));

            departmentRepo.delete(department);
        } catch (DepartmentNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}