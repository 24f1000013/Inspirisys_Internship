package com.example.crud.service;

import com.example.crud.dto.CollegeDTO;
import com.example.crud.entity.College;
import com.example.crud.exception.CollegeNotFoundException;
import com.example.crud.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository repo;

    public College createCollege(CollegeDTO dto) {
        try {
            College college = new College();
            college.setCollegeName(dto.getCollegeName());
            college.setLocation(dto.getLocation());
            college.setContactNumber(dto.getContactNumber());
            college.setEmail(dto.getEmail());

            return repo.save(college);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<College> getAllColleges() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public College getCollegeById(Integer id) {
        try {
            return repo.findById(id)
                    .orElseThrow(() -> new CollegeNotFoundException("College ID not found in table"));
        } catch (CollegeNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public College updateCollege(Integer id, CollegeDTO dto) {
        try {
            College existing = repo.findById(id)
                    .orElseThrow(() -> new CollegeNotFoundException("College ID not found in table"));

            existing.setCollegeName(dto.getCollegeName());
            existing.setLocation(dto.getLocation());
            existing.setContactNumber(dto.getContactNumber());
            existing.setEmail(dto.getEmail());

            return repo.save(existing);
        } catch (CollegeNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteCollege(Integer id) {
        try {
            College college = repo.findById(id)
                    .orElseThrow(() -> new CollegeNotFoundException("College ID not found in table"));

            repo.delete(college);
        } catch (CollegeNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}