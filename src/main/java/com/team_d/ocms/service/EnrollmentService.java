package com.team_d.ocms.service;

import com.team_d.ocms.dto.EnrollmentRequest;
import com.team_d.ocms.dto.EnrollmentResponse;
import com.team_d.ocms.entity.Course;
import com.team_d.ocms.entity.Enrollment;
import com.team_d.ocms.entity.Student;
import com.team_d.ocms.repository.CourseRepository;
import com.team_d.ocms.repository.EnrollmentRepository;
import com.team_d.ocms.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(
        EnrollmentRepository enrollmentRepository,
        StudentRepository studentRepository,
        CourseRepository courseRepository) {
    this.enrollmentRepository = enrollmentRepository;
    this.studentRepository = studentRepository;
    this.courseRepository = courseRepository;
}

    public List<EnrollmentResponse> getEnrollmentsByStudentId(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);

        // Convert entities to DTOs
        return enrollments.stream()
                .map(this::mapToEnrollmentResponse)
                .collect(Collectors.toList());
    }

    public List<EnrollmentResponse> getEnrollmentsByCourseId(Long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(courseId);

        // Convert entities to DTOs
        return enrollments.stream()
                .map(this::mapToEnrollmentResponse)
                .collect(Collectors.toList());
    }

    private EnrollmentResponse mapToEnrollmentResponse(Enrollment enrollment) {
        // Convert entity to DTO
        EnrollmentResponse response = new EnrollmentResponse();
        // Set properties based on entity
       // response.setEnrollmentId(enrollment.getEnrollmentId());
       response.setStudentId(enrollment.getStudent().getStudentId());
       response.setName(enrollment.getStudent().getName().toString());
       response.setCourseId(enrollment.getCourse().getCourseId());
       response.setCourseName(enrollment.getCourse().getCourseName());
       response.setEnrollmentDate(enrollment.getEnrollmentDate().toString());
   

        // Set other properties based on entity

        return response;
    }

public Enrollment createEnrollment(EnrollmentRequest enrollmentRequest) {
    // Convert DTO to entity
    Enrollment enrollment = new Enrollment();
    
    // Set properties based on DTO
    enrollment.setEnrollmentDate(enrollmentRequest.getEnrollmentDate());
    
    // Retrieve and set associated Student and Course
    Student student = studentRepository.findById(enrollmentRequest.getStudentId()).orElse(null);
    Course course = courseRepository.findById(enrollmentRequest.getCourseId()).orElse(null);
    
    // Set Student and Course in the Enrollment entity
    enrollment.setStudent(student);
    enrollment.setCourse(course);
    
    // Save the entity
    return enrollmentRepository.save(enrollment);
}

}
