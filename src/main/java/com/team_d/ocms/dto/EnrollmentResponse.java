package com.team_d.ocms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponse{

    private Long studentId;
    private String name;
    private Long courseId;
    private String courseName;
    private String enrollmentDate;
    // Add any other fields you want to include in the response
}
