package com.cocoh.student.domain;

/* 2025-08-29 학생 DB 설계 및 생성 - 최현우 - */

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String studentId;

    @Column
    private String age;

    @Column
    private String major;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();

    @Builder
    public Student(Long id, String name, String studentId, String age, String major) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.age = age;
        this.major = major;
    }
}
