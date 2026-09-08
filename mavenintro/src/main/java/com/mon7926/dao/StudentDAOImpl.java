package com.mon7926.dao;

import java.util.Map;
import java.util.HashMap;

import com.mon7926.Student;

//this class is used to perform crud operations for student entity
//access the database
public class StudentDAOImpl {

private static Map<Integer, Student> studentMap = new HashMap<>();
   static{
    studentMap.put(1, new Student("sidhu",1    ));
    studentMap.put(2, new Student("Jane Smith", 2));
    studentMap.put(3, new Student("Alice Johnson", 3));
   }

   //method to get student by name
   public Student getStudentByName(String name) {
       for (Student student : studentMap.values()) {
           if (student.getName().equals(name)) {
               return student;
           }
       }
       return null;
   }
 
   //add a new student
   public void addStudent(Student student) {
       studentMap.put(student.getAge(), student);
       System.out.println("Added student: " + student.getName());
   }
}
