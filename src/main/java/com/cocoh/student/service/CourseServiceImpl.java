package com.cocoh.student.service;

import com.cocoh.student.domain.Course;
import com.cocoh.student.domain.Student;
import com.cocoh.student.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Page<Course> findCourseList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize());
        return courseRepository.findAll(pageable);
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElse(new Course());
    }

}
