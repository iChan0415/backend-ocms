package com.team_d.ocms.dto;

import lombok.Data;

@Data
public class QuizCreateRequest {

    private String quizName;

    private Long courseId;

    private String quizFile;

    private String description;

    private int targetScore;

    // Other fields if needed
}
