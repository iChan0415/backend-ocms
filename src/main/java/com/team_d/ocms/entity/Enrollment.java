package com.team_d.ocms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//import java.util.Date; // Assuming enrollmentDate is a Date or timestamp

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Enrollment {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "enrollment_sequence"
  )
  @SequenceGenerator(
    name = "enrollment_sequence",
    sequenceName = "enrollment_seq",
    allocationSize = 1,
    initialValue = 1
  )
  private Long enrollmentId;

  private String enrollmentDate;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id")
  private Course course;
  // Constructors, getters, setters, etc.
}
