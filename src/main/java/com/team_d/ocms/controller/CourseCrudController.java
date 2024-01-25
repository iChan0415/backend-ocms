package com.team_d.ocms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.team_d.ocms.dto.CourseCreateRequest;
import com.team_d.ocms.dto.CourseCreateResponse;
import com.team_d.ocms.entity.Course;
import com.team_d.ocms.entity.Instructor;
import com.team_d.ocms.repository.CourseRepository;
import com.team_d.ocms.repository.InstructorRepository;
import com.team_d.ocms.service.InstructorService;



@RestController
@RequestMapping("/courses") // Base path for this controller

public class CourseCrudController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorService instructorService;
    @Autowired
    private InstructorRepository instructorRepository;

    @PostMapping("/save")
    public ResponseEntity<Instructor> saveCourseInstructor(@RequestBody CourseCreateRequest request) {
        Instructor savedInstructor = instructorService.saveInstructorFromRequest(request);
        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }

    @GetMapping("/instructors")
    public List<Instructor> getAllInstructorInfo() {
    return instructorService.getAllInstructorInfo();
    }

    @GetMapping("/instructors/{instructorId}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long instructorId) {
    Optional<Instructor> instructorOptional = instructorService.getInstructorById(instructorId);

    return instructorOptional.map(instructor -> new ResponseEntity<>(instructor, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

    @GetMapping("/info")
    public List<CourseCreateResponse> findAllCourseInfo() {
        return instructorRepository.findAllCourseInfo();
    }

    @GetMapping("/info/{instructorId}")
    public ResponseEntity<List<CourseCreateResponse>> getCourseInfoByInstructorId(@PathVariable Long instructorId) {
        List<CourseCreateResponse> courseInfo = instructorRepository.getCourseInfoByInstructorId(instructorId);

        return courseInfo.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(courseInfo, HttpStatus.OK);
    }

    @GetMapping("/byCourseId/{courseId}")
    public ResponseEntity<List<Course>> getCourseByCourseId(@PathVariable Long courseId) {
        List<Course> courses = courseRepository.findByCourseId(courseId);

        return courses.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(courses, HttpStatus.OK);
    }

    
}
