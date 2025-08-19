package com.cocoh.student.controller;

import com.cocoh.student.domain.Course;
import com.cocoh.student.domain.Enrollment;
import com.cocoh.student.domain.Student;
import com.cocoh.student.dto.EnrollmentCancelRequest;
import com.cocoh.student.dto.EnrollmentNameRequest;
import com.cocoh.student.repository.CourseRepository;
import com.cocoh.student.repository.EnrollmentRepository;
import com.cocoh.student.repository.StudentRepository;
import com.cocoh.student.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<?> list(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(enrollmentService.findEnrollmentList(pageable));
    }

    @PostMapping("/id")
    public ResponseEntity<?> addEnrollmentId(@RequestBody Enrollment enroll) {
        Student student = studentRepository.findById(enroll.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("student not found"));

        Course course = courseRepository.findById(enroll.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return ResponseEntity.ok(savedEnrollment);
    }

    @PostMapping("/name")
    public ResponseEntity<?> addEnrollmentName(@RequestBody EnrollmentNameRequest request) {
        Student student = studentRepository.findByStudentId(request.getStudentId());

        Course course = courseRepository.findByCourseNameAndCourseAdvisor(request.getCourseName(), request.getCourseAdvisor());
        if (course == null) {
            return ResponseEntity.badRequest().body("course not found");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return ResponseEntity.ok(savedEnrollment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        enrollmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<?> cancelEnrollment(@RequestBody EnrollmentCancelRequest request) {
        Student student = studentRepository.findByStudentId(request.getStudentId());
        if (student == null) {
            return ResponseEntity.badRequest().body("student not found");
        }

        Course course = courseRepository.findByCourseNameAndCourseAdvisor(
                request.getCourseName(), request.getCourseAdvisor()
        );
        if (course == null) {
            return ResponseEntity.badRequest().body("course not found");
        }

        Enrollment enrollment = enrollmentRepository.findByStudentAndCourse(student, course);
        if (enrollment == null) {
            return ResponseEntity.badRequest().body("enrollment not found");
        }

        enrollmentRepository.delete(enrollment);
        return ResponseEntity.noContent().build();
    }

}
