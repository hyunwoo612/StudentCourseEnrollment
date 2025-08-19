package com.cocoh.student.repository;

import com.cocoh.student.domain.Course;
import com.cocoh.student.domain.Enrollment;
import com.cocoh.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
//    void deleteByEnrollment(String studentId, String courseName, String courseAdvisor);
    Enrollment findByStudentAndCourse(Student student, Course course);
}
