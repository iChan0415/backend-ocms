package com.team_d.ocms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Instructor {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "instructor_sequence"
  )
  @SequenceGenerator(
    name = "instructor_sequence",
    sequenceName = "instructor_seq",
    allocationSize = 1,
    initialValue = 1
  )
  private Long instructorId;

  private String name;
  private String email;
  private String password;
  private String profile;

  @OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "instructor_id", referencedColumnName = "instructorId")
  private java.util.List<Course> courses;
}
