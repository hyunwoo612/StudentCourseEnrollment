package com.cocoh.student.controller;

import com.cocoh.student.domain.Student;
import com.cocoh.student.repository.StudentRepository;
import com.cocoh.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/list")
    public ResponseEntity<?> list(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(studentService.findStudentList(pageable));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student student) {
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("student not found"));

        updateStudent.setName(student.getName());
        updateStudent.setStudentId(student.getStudentId());
        updateStudent.setAge(student.getAge());
        updateStudent.setMajor(student.getMajor());

        return ResponseEntity.ok(studentRepository.save(updateStudent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
