package com.cocoh.student.domain;

/* 2025-08-29 등록(수강 신청) DB 설계 및 생성 - 최현우 - */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 학생
    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties("enrollments")
    private Student student;

    // 과목
    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnoreProperties("enrollments")
    private Course course;

}
