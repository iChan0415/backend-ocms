package com.team_d.ocms.controller;

import com.team_d.ocms.dto.QuizCreateRequest;
import com.team_d.ocms.dto.QuizResponse;
import com.team_d.ocms.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/create")
    public ResponseEntity<QuizResponse> createQuiz(@RequestBody QuizCreateRequest quizRequest) {
        QuizResponse createdQuiz = quizService.createQuiz(quizRequest);
        return new ResponseEntity<>(createdQuiz, HttpStatus.CREATED);
    }

    @GetMapping("/byCourse/{courseId}")
    public ResponseEntity<List<QuizResponse>> getQuizzesByCourseId(@PathVariable Long courseId) {
        List<QuizResponse> quizzes = quizService.getQuizzesByCourseId(courseId);
        return quizzes.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    // Additional CRUD operations like update and delete
}
