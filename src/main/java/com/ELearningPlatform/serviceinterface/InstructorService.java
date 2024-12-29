package com.ELearningPlatform.serviceinterface;

import com.ELearningPlatform.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);
    Instructor updateInstructor(Long id, Instructor instructor);
    void deleteInstructor(Long id);
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Long id);
}
