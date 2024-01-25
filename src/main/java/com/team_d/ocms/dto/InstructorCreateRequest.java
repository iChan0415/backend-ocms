package com.team_d.ocms.dto;

import com.team_d.ocms.entity.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class InstructorCreateRequest {
    
    private Instructor instructor;
}
