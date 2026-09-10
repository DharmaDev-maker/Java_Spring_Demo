package com.jpademo.jpa10926.Service;
import com.jpademo.jpa10926.beans.Student;
public interface StudentService {

  int save(Student student);
  Student getStudentById(int studentId);
   Student updateStudent(Student student);
  void deleteStudent(int studentId);

}
