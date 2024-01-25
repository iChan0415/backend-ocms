package com.team_d.ocms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quiz {

      @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "quiz_sequence"
  )
  @SequenceGenerator(
    name = "quiz_sequence",
    sequenceName = "quiz_seq",
    allocationSize = 1,
    initialValue = 1
  )
    private Long quizId;

    private String quizName;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String quizFile;

    private String description;

    private int targetScore;

    // Other fields, constructors, getters, setters, etc.
}
