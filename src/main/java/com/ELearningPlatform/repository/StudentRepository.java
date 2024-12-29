package com.ELearningPlatform.repository;

import com.ELearningPlatform.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s JOIN s.enrollments e WHERE e.course.id = :id")
    List<Student> findByCourseId(@Param("id") Long id);

    Student findByEmail(String email);
}
