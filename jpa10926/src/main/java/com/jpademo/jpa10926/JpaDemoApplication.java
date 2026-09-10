package com.jpademo.jpa10926;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpademo.jpa10926.Service.StudentService;
import com.jpademo.jpa10926.Service.StudentServiceImpl;
import com.jpademo.jpa10926.beans.Student;


public class JpaDemoApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(com.jpademo.jpa10926.config.SprinDBContext.class);

      StudentService studentService = context.getBean(StudentServiceImpl.class);

        createStudent(studentService);
        getStudentById(studentService, 1); // Example usage to retrieve student with ID 1
        updateStudent(studentService, 1); // Example usage to update student with ID 1
        deleteStudent(studentService, 1); // Example usage to delete student with ID 1
    }

    private static void createStudent(StudentService studentService) {

        Student student = new Student();

        
        student.setName("sidhu");
        student.setMark(80);

        int studentId = studentService.save(student);
        if (studentId > 0) {
            System.out.println("Student created successfully with ID: " + studentId);
        } else {
            System.out.println("Failed to create student.");
        }
    }

    private static void getStudentById(StudentService studentService, int studentId) {
    try {
        Student student = studentService.getStudentById(studentId);
        System.out.println("Student retrieved: " + student);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
    private static void updateStudent(StudentService studentService, int studentId) {
        try {
            Student student = studentService.getStudentById(studentId);
            if (student != null) {
                student.setName("Updated Name");
                student.setMark(90);
                Student updatedStudent = studentService.updateStudent(student);
                System.out.println("Student updated: " + updatedStudent);
            } else {
                System.out.println("Student not found with ID: " + studentId);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
    //deleteStudent method needs to be done
    private static void deleteStudent(StudentService studentService, int studentId) {
        try {
            Student student = studentService.getStudentById(studentId);
            if (student != null) {
                // Assuming there is a deleteStudent method in the service
                studentService.deleteStudent(studentId);
                System.out.println("Student deleted with ID: " + studentId);
            } else {
                System.out.println("Student not found with ID: " + studentId);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}