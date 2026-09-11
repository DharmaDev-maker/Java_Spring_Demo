package com.practice.student_mange;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import com.practice.student_mange.Config.SpringDbCOntext;
import com.practice.student_mange.Entity.Student;
import com.practice.student_mange.Service.StudentService;
import com.practice.student_mange.Service.StudentServiceImpl;

//@SpringBootApplication
public class StudentMangApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringDbCOntext.class);
		try {
			StudentService studentService = context.getBean(StudentServiceImpl.class);
			//createstudent(studentService);
			//getStudentById(studentService, 1L);
			//updateStudent(studentService, new Student("sidhu.doe@example.com", "sidhu@", "2000-01-01"));
			getAllStudents(studentService);
			// You can add more method calls here to test other functionalities, e.g., update, delete, get all students.
		} finally {
			((AnnotationConfigApplicationContext) context).close();
		}
	}

	private static void createstudent(StudentService studentService) {
		Student student = new Student();
		student.setName("sidhu");
		student.setEmail("sidhu.doe@example.com");
		studentService.createStudent(student);
		if(student != null){
			System.out.println("Student created successfully: " + student.getName());
		}
	}
	public static void getStudentById(StudentService studentService, Long id){
		Student student = studentService.getStudentById(id);
		if(student != null){
			System.out.println("Student retrieved successfully: " + student.getName());
		} else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}
	public static void updateStudent(StudentService studentService, Student student){
		studentService.updateStudent(student);
		System.out.println("Student updated successfully: " + student.getName());
	}

	// public static void deleteStudent(StudentService studentService, Long id){
	// 	studentService.deleteStudent(id);
	// 	System.out.println("Student deleted successfully with ID: " + id);
	// }

	public static void getAllStudents(StudentService studentService){
		List<Student> students = studentService.getAllStudents();
		System.out.println("All students retrieved successfully:");
		for(Student student : students){
			System.out.println(" - " + student.getName());
		}
	}
	

}
