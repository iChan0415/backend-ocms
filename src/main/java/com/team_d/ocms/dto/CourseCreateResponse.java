package com.team_d.ocms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)


public class CourseCreateResponse {

    private Long instructorId;
    private String name;
    private String courseName;
    private Long courseId;
    private String description;
    

    public CourseCreateResponse(long instructorId, String name, Long courseId, String courseName, String description) {
        this.instructorId = instructorId;
        this.name = name;
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
    }

    public CourseCreateResponse(String courseName, Long courseId, String description, String name) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.description = description;
        this.name = name;
    }
    
}
