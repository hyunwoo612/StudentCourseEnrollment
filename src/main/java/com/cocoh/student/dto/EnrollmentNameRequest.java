package com.cocoh.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollmentNameRequest {
    private String studentId;
    private String courseName;
    private String courseAdvisor;
}
