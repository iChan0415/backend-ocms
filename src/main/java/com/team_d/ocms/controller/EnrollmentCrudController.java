package com.team_d.ocms.controller;

import com.team_d.ocms.dto.EnrollmentRequest;
import com.team_d.ocms.dto.EnrollmentResponse;
import com.team_d.ocms.entity.Enrollment;
import com.team_d.ocms.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentCrudController {

    private final EnrollmentService enrollmentService;

    public EnrollmentCrudController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody EnrollmentRequest enrollmentRequest) {
        Enrollment createdEnrollment = enrollmentService.createEnrollment(enrollmentRequest);
        return new ResponseEntity<>(createdEnrollment, HttpStatus.CREATED);
    }
    
    @GetMapping("/byStudent/{studentId}")
    public ResponseEntity<List<EnrollmentResponse>> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        List<EnrollmentResponse> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return enrollments.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/byCourse/{courseId}")
    public ResponseEntity<List<EnrollmentResponse>> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        List<EnrollmentResponse> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
        return enrollments.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

 
    // Additional CRUD operations like update and delete
}
