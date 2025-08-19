package com.cocoh.student.repository;

import com.cocoh.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
    Student findByStudentId(String studentId);
}
