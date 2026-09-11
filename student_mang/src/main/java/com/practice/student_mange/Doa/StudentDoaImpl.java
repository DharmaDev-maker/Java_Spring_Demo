package com.practice.student_mange.Doa;
import org.springframework.transaction.annotation.Transactional;

import com.practice.student_mange.Entity.Student;

import org.springframework.stereotype.Repository;
import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional(value="transactionManager") //what is this in short: It is a Spring annotation that indicates that the 
// methods in this class should be executed within a transactional context managed by the specified transaction manager.
@Repository //what is repository in short: It is a Spring annotation that indicates this class is a 
// Data Access Object (DAO) and will handle database operations.
public class StudentDoaImpl implements StudentDao {
   
@PersistenceContext  
private EntityManager entityManager;

    @Override
    public void createStudent(Student student) {
        // Implementation for creating a student in the database
        entityManager.persist(student); //
     //doa layer has called createStudent
        System.out.println("DOA layer has called createStudent for: " + student);
    }

    @Override
    public Student getStudentById(Long id) {
        // Implementation for retrieving a student by ID from the database
       
        Student student = null;
        try {
            student = entityManager.find(Student.class, id);
        } catch (Exception e) {
            System.out.println("Error occurred while retrieving student with ID: " + id);
            e.printStackTrace();
        }
        System.out.println("DOA layer has called getStudentById for ID: " + id);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        // Implementation for updating a student in the database
        entityManager.merge(student); // what this does: It updates the existing student
        //   entity in the database with the new values provided in the student object.
        System.out.println("DOA layer has called updateStudent for: " + student);
    }

    @Override
    public void deleteStudent(Long id) {
        // Implementation for deleting a student from the database
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
            System.out.println("DOA layer has called deleteStudent for ID: " + id);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        // Implementation for retrieving all students from the database
     List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList(); //instead of tis how  we can write in simple way
        // This query retrieves all Student entities from the database.
          
        System.out.println("DOA layer has called getAllStudents");
        return students;
    }
}
