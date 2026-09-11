package com.practice.student_mange.Doa;

import org.springframework.stereotype.Repository;
import com.practice.student_mange.Entity.Course;
import java.util.List;
@Repository //what is repository in short: It is a Spring annotation that indicates this class is a 
// Data Access Object (DAO) and will handle database operations.
public class CourseDoaImpl implements CourseDoa {
    @Override
    public void createCourse(Course course) {
        // Implementation for creating a course in the database
    }

    @Override
    public void updateCourse(Course course) {
        // Implementation for updating a course in the database
    }

    @Override
    public void deleteCourse(Long id) {
        // Implementation for deleting a course from the database
    }

    @Override
    public List<Course> getAllCourses() {
        // Implementation for retrieving all courses from the database
        return null;
    }
}
