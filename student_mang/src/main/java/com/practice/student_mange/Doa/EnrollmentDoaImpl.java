package com.practice.student_mange.Doa;
import com.practice.student_mange.Entity.Enrollment;
import com.practice.student_mange.Entity.Course;
import com.practice.student_mange.Entity.Student;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository //what is repository in short: It is a Spring annotation that indicates this class is a 
// Data Access Object (DAO) and will handle database operations.
public class EnrollmentDoaImpl implements EnrollmentDoa {
    @Override
    public void enrollStudent(Enrollment enrollment) {
        // Implementation for enrolling a student in a course in the database
    }

    @Override
    public void unenrollStudent(Enrollment enrollment) {
        // Implementation for unenrolling a student from a course in the database
    }

    @Override
    public List<Course> getCoursesOfStudent(Long studentId) {
        // Implementation for retrieving all courses of a student from the database
        return null;
    }

    @Override
    public List<Student> getStudentsInCourse(Long courseId) {
        // Implementation for retrieving all students in a course from the database
        return null;
    }

}
