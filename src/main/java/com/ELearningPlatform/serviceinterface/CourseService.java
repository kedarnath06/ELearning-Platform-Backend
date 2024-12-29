package com.ELearningPlatform.serviceinterface;

import com.ELearningPlatform.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    List<Course> getCoursesByInstructorId(Long instructorId);
}
