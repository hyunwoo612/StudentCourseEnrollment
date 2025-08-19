package com.cocoh.student.service;

import com.cocoh.student.domain.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnrollmentService {
    Page<Enrollment> findEnrollmentList(Pageable pageable);
}
