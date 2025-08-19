package com.cocoh.student.service;

import com.cocoh.student.domain.Student;
import com.cocoh.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Page<Student> findStudentList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize());
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(new Student());
    }

}
