package com.practice.student_mange.Service;

import java.util.List;

import com.practice.student_mange.Entity.Student;

public interface StudentService {

 public void createStudent(Student student) ;
 Student getStudentById(Long id);
void updateStudent(Student student);
void deleteStudent(Long id);
List<Student> getAllStudents();

}
