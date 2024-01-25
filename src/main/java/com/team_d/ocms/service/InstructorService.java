package com.team_d.ocms.service;

import com.team_d.ocms.dto.CourseCreateRequest;
import com.team_d.ocms.entity.Instructor;
import com.team_d.ocms.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor saveInstructorFromRequest(CourseCreateRequest request) {
        return instructorRepository.save(request.getInstructor());
    }
    
    
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(Long instructorId) {
        return instructorRepository.findById(instructorId);
    }

    public List<Instructor> getAllInstructorInfo() {
        return instructorRepository.findAll(); 
}
}
