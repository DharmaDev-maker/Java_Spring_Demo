package com.jpademo.jpa10926.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpademo.jpa10926.beans.Student;
import com.jpademo.jpa10926.DAO.StudentDAOImpl;
import com.jpademo.jpa10926.Service.StudentService;
@Service 
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAOImpl studentDAO;

     
    @Override
    public int save(Student student) {
        // Implement the save logic here
        return studentDAO.save(student); // Return the generated student ID or 0 if failed
    }
    @Override
    public Student getStudentById(int studentId) {
        return studentDAO.getStudentById(studentId);
    }
    
    @Override
    public Student updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }
    @Override
    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }
}
