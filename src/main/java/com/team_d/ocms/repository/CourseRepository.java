package com.team_d.ocms.repository;

import com.team_d.ocms.entity.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
  List<Course> findByCourseId(Long courseId);
}
