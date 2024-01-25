package com.team_d.ocms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EnrollmentRequest {
    
    private Long studentId;
    private String name;
    private Long courseId;
    private String courseName;
    private String enrollmentDate;
    // Add any other fields you need for creating enrollments
}
