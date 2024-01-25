package com.team_d.ocms.service;

import com.team_d.ocms.dto.QuizCreateRequest;
import com.team_d.ocms.dto.QuizResponse;
import com.team_d.ocms.entity.Course;
import com.team_d.ocms.entity.Quiz;
import com.team_d.ocms.repository.CourseRepository;
import com.team_d.ocms.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final CourseRepository courseRepository;

    public QuizService(QuizRepository quizRepository, CourseRepository courseRepository) {
        this.quizRepository = quizRepository;
        this.courseRepository = courseRepository;
    }

    public QuizResponse createQuiz(QuizCreateRequest quizRequest) {
        Course course = courseRepository.findById(quizRequest.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Quiz quiz = new Quiz();
        quiz.setQuizName(quizRequest.getQuizName());
        quiz.setCourse(course);
        quiz.setQuizFile(quizRequest.getQuizFile());
        quiz.setDescription(quizRequest.getDescription());
        quiz.setTargetScore(quizRequest.getTargetScore());

        Quiz createdQuiz = quizRepository.save(quiz);

        return mapToQuizResponse(createdQuiz);
    }

    public List<QuizResponse> getQuizzesByCourseId(Long courseId) {
        List<Quiz> quizzes = quizRepository.findByCourseId(courseId);

        return quizzes.stream()
                .map(this::mapToQuizResponse)
                .collect(Collectors.toList());
    }

    private QuizResponse mapToQuizResponse(Quiz quiz) {
        QuizResponse response = new QuizResponse();
        response.setQuizId(quiz.getQuizId());
        response.setQuizName(quiz.getQuizName());
        response.setCourseId(quiz.getCourse().getCourseId());
        response.setQuizFile(quiz.getQuizFile());
        response.setDescription(quiz.getDescription());
        response.setTargetScore(quiz.getTargetScore());

        // Other fields if needed

        return response;
    }
}
