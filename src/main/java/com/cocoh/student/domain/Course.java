package com.cocoh.student.domain;

/* 2025-08-29 과목 DB 설계 및 생성 - 최현우 - */

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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private Long id;

    // 과목명
    @Column
    private String courseName;

    // 과목코드
    @Column
    private String courseCode;

    // 담당 교수 or 선생님
    @Column
    private String courseAdvisor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();

    @Builder
    public Course(Long id, String courseName, String courseCode, String courseAdvisor) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseAdvisor = courseAdvisor;
    }
}
