package com.ELearningPlatform.serviceimplementation;

import com.ELearningPlatform.entity.Enrollment;
import com.ELearningPlatform.exception.EnrollmentNotFoundException;
import com.ELearningPlatform.repository.EnrollmentRepository;
import com.ELearningPlatform.serviceinterface.EnrollmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    @Transactional
    public Enrollment enrollStudent(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    @Transactional
    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        Enrollment existingEnrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));

        existingEnrollment.setCourse(enrollment.getCourse());
        existingEnrollment.setStudent(enrollment.getStudent());
        existingEnrollment.setEnrollmentDate(enrollment.getEnrollmentDate());
        return enrollmentRepository.save(existingEnrollment);
    }

    @Override
    @Transactional
    public void deleteEnrollment(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new EnrollmentNotFoundException(id);
        }
        enrollmentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
