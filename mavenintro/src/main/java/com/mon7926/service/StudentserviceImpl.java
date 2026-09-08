package com.mon7926.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

import com.mon7926.Student18926;
import com.mon7926.dao.StudentDAOImpl;
import com.mon7926.eception.StudentNotFoundException;

//used to manager the exceptions , and provide service layer logic for student operations
//provides the core logic or bussiness logic
@Service("StudentserviceImpl")
public class StudentserviceImpl {
    @Autowired 
    StudentDAOImpl s;

    //getStudentByName,addStudent this methods deal with database 
    public void printStudentByName(String name) {
        System.out.println(s.getStudentByName(name));
    }
    
    public void addStudent(Student18926 student) {
        s.addStudent(student);
    }
    //update
    public void updateStudent(Student18926 student) {
        s.addStudent(student); // Assuming addStudent will replace the existing student with the same age
    }

    //delete i have exception calss mavenintro/src/main/java/com/mon7926/eception/StudentNotFoundException.java
    public void deleteStudentByName(String name) {
        Student18926 student = s.getStudentByName(name);
        if (student != null) {
            removeStudentFromDao(student);
            System.out.println("Deleted student: " + name);
        } else {
            throw new StudentNotFoundException("Student with name " + name + " not found");
        }
    }
    
    //list all students
    public Map<Integer, Student18926> getAllStudents() {
        return s.getAllStudents();
    }

    private void removeStudentFromDao(Student18926 student) {
        for (Field field : StudentDAOImpl.class.getDeclaredFields()) {
            if (Map.class.isAssignableFrom(field.getType())) {
                try {
                    field.setAccessible(true);
                    Map<?, ?> students = (Map<?, ?>) field.get(s);
                    students.remove(student.getAge());
                    return;
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("Unable to delete student", e);
                }
            }
        }
        throw new IllegalStateException("StudentDAOImpl does not contain a student map");
    }

}
