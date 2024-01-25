package com.team_d.ocms.dto;

import com.team_d.ocms.entity.Course;
import com.team_d.ocms.entity.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CourseCreateRequest {

    private Instructor instructor;
    
    private Course course;


    public Instructor getInstructor() {
        return this.instructor;
    }
    
}
