package com.team_d.ocms.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Course {

  @Id
  private Long courseId;

  private String courseName;
  private String description;
  private String courseFile;
  private String courseImage;
public Long getId() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getId'");
}

}
