package com.cocoh.student.service;

import com.cocoh.student.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService  {
    Page<Student> findStudentList(Pageable pageable);
    Student findStudentById(Long id);
}
