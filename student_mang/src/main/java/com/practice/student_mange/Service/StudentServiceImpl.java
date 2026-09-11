package com.practice.student_mange.Service;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.practice.student_mange.Entity.Student;
import com.practice.student_mange.Doa.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override 
    public void createStudent(Student student) {
        // Implementation for creating a student
        studentDao.createStudent(student);
        //print service layer has called
        System.out.println("Service layer has called createStudent for: " + student);

    }
    @Override
    public Student getStudentById(Long id) {
        // Implementation for retrieving a student by ID
        Student student = studentDao.getStudentById(id);
        System.out.println("Service layer has called getStudentById for ID: " + id);
        return student;
    }
    @Override
    public void updateStudent(Student student) {
        // Implementation for updating a student
        studentDao.updateStudent(student);
        System.out.println("Service layer has called updateStudent for: " + student);
    }

    @Override
    public void deleteStudent(Long id) {
        // Implementation for deleting a student
        studentDao.deleteStudent(id);
        System.out.println("Service layer has called deleteStudent for ID: " + id);
    }

    @Override
    public List<Student> getAllStudents() {
        // Implementation for retrieving all students
        List<Student> students = studentDao.getAllStudents();
        System.out.println("Service layer has called getAllStudents");
        return students;
    }
}
