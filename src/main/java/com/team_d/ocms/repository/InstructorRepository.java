package com.team_d.ocms.repository;

import com.team_d.ocms.dto.CourseCreateResponse;
import com.team_d.ocms.entity.Instructor;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
  @Query(
    "SELECT new com.team_d.ocms.dto.CourseCreateResponse(i.instructorId, i.name, c.courseId, c.courseName, c.description) FROM Instructor i JOIN i.courses c"
  )
  List<CourseCreateResponse> findAllCourseInfo();

  @Query(
    "SELECT new com.team_d.ocms.dto.CourseCreateResponse(c.courseName, c.courseId, c.description, i.name) FROM Instructor i JOIN i.courses c WHERE i.instructorId = :instructorId"
  )
  List<CourseCreateResponse> getCourseInfoByInstructorId(
    @Param("instructorId") Long instructorId
  );

}
