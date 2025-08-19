package com.cocoh.student.service;

import com.cocoh.student.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Page<Course> findCourseList(Pageable pageable);
    Course findCourseById(Long id);
}
