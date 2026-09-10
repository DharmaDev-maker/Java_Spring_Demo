package com.jpademo.jpa10926.DAO;

import com.jpademo.jpa10926.beans.Student;

public interface StudentDAO {

    public int save(Student student);
    public Student getStudentById(int studentId);
    //updateStudent method
    public Student updateStudent(Student student);
    //deleteStudent method
    public void deleteStudent(int studentId);
}
