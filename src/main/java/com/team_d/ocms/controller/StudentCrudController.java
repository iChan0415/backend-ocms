package com.team_d.ocms.controller;

import com.team_d.ocms.entity.Student;
import com.team_d.ocms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentCrudController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Optional<Student> studentOptional = studentService.getStudentById(studentId);

        return studentOptional.map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   
}
