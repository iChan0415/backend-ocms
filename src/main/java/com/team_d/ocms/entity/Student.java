package com.team_d.ocms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Student {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequence"
  )
  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_seq",
    allocationSize = 1,
    initialValue = 1
  )
  private Long studentId;

  private String name;
  private String email;
  private String password;
  private String profile;

  
}
