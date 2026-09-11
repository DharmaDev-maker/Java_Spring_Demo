package com.practice.student_mange.Doa;
import com.practice.student_mange.Entity.Enrollment;
import com.practice.student_mange.Entity.Course;
import com.practice.student_mange.Entity.Student;
import java.util.List;

public interface EnrollmentDoa {
   void enrollStudent(Enrollment enrollment);
   void unenrollStudent(Enrollment enrollment);
   List<Course> getCoursesOfStudent(Long studentId);
   List<Student> getStudentsInCourse(Long courseId);
}
