package com.cocoh.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollmentCancelRequest {
    private String studentId;
    private String courseName;
    private String courseAdvisor;
}
