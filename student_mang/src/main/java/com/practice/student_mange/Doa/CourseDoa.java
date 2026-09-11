package com.practice.student_mange.Doa;
import com.practice.student_mange.Entity.Course;
import java.util.List;
public interface CourseDoa {
   void createCourse(Course course);
   void updateCourse(Course course);
   void deleteCourse(Long id);
   List<Course> getAllCourses();
}
