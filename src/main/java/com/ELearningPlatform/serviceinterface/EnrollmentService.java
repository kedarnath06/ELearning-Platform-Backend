package com.ELearningPlatform.serviceinterface;

import com.ELearningPlatform.entity.Enrollment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollStudent(Enrollment enrollment);
    Enrollment updateEnrollment(Long id, Enrollment enrollment);
    void deleteEnrollment(Long id);
    List<Enrollment> getEnrollmentsByStudentId(Long studentId);
    List<Enrollment> getEnrollmentsByCourseId(Long courseId);

    @Transactional(readOnly = true)
    Enrollment getEnrollmentById(Long id);

    @Transactional(readOnly = true)
    List<Enrollment> getAllEnrollments();
}
