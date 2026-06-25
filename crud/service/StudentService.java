package com.example.crud.service;

import com.example.crud.dto.StudentDTO;
import com.example.crud.entity.Department;
import com.example.crud.entity.Student;
import com.example.crud.exception.StudentNotFoundException;
import com.example.crud.repository.DepartmentRepository;
import com.example.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    public Student createStudentUser(StudentDTO dto) {
        try {
            Department department = departmentRepo.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));

            Student student = new Student();
            student.setName(dto.getName());
            student.setAge(dto.getAge());
            student.setMobile(dto.getMobile());
            student.setEmail(dto.getEmail());
            student.setPassedOut(dto.isPassedOut());
            student.setDepartment(department);

            return studentRepo.save(student);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Student createStudentEnquiry(StudentDTO dto) {
        try {
            Student student = new Student();
            student.setName(dto.getName());
            student.setAge(dto.getAge());
            student.setMobile(dto.getMobile());
            student.setEmail(dto.getEmail());
            student.setPassedOut(dto.isPassedOut());

            if (dto.getDepartmentId() != null) {
                Department department = departmentRepo.findById(dto.getDepartmentId()).orElse(null);
                student.setDepartment(department);
            }

            return studentRepo.save(student);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        try {
            return studentRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Student getStudentUserById(Integer id) {
        try {
            return studentRepo.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException("Student ID not found in table"));
        } catch (StudentNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Student getStudentEnquiryById(Integer id) {
        try {
            return studentRepo.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException("Student ID not found in table"));
        } catch (StudentNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Student updateStudent(Integer id, StudentDTO dto) {
        try {
            Student student = studentRepo.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException("Student ID not found in table"));

            Department department = departmentRepo.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));

            student.setName(dto.getName());
            student.setAge(dto.getAge());
            student.setMobile(dto.getMobile());
            student.setEmail(dto.getEmail());
            student.setPassedOut(dto.isPassedOut());
            student.setDepartment(department);

            return studentRepo.save(student);
        } catch (StudentNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteStudent(Integer id) {
        try {
            Student student = studentRepo.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException("Student ID not found in table"));

            studentRepo.delete(student);
        } catch (StudentNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Student> getStudentsByDepartment(String department) {
        try {
            return studentRepo.getStudentsByDepartment(department);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}