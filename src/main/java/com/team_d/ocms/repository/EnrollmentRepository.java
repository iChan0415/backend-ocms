package com.team_d.ocms.repository;

import com.team_d.ocms.entity.Enrollment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
  // Custom query to find enrollments by studentId
  @Query("SELECT e FROM Enrollment e WHERE e.student.studentId = :studentId")
  List<Enrollment> findByStudentId(@Param("studentId") Long studentId);

  // Custom query to find enrollments by courseId
  @Query("SELECT e FROM Enrollment e WHERE e.course.courseId = :courseId")
  List<Enrollment> findByCourseId(@Param("courseId") Long courseId);
}
