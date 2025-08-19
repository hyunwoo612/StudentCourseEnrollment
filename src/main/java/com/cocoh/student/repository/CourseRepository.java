package com.cocoh.student.repository;

import com.cocoh.student.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseNameAndCourseAdvisor(String courseName, String courseAdvisor);
}
