package com.practice.student_mange.Doa;

import com.practice.student_mange.Entity.Student;
import java.util.List;

public interface StudentDao {
    void createStudent(Student student);
     Student getStudentById(Long id);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getAllStudents();
}
