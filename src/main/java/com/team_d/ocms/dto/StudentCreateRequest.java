package com.team_d.ocms.dto;


import com.team_d.ocms.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class StudentCreateRequest {
 
    private Student student;
}
