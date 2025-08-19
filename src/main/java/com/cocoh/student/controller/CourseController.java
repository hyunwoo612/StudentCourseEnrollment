package com.cocoh.student.controller;

import com.cocoh.student.domain.Course;
import com.cocoh.student.repository.CourseRepository;
import com.cocoh.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/list")
    public ResponseEntity<?> list(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(courseService.findCourseList(pageable));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Course course) {
        return ResponseEntity.ok(courseRepository.save(course));
    }
}
