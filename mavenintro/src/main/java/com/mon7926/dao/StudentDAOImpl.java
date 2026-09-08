package com.mon7926.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

import com.mon7926.Student18926;

@Repository 
public class StudentDAOImpl {

private static Map<Integer, Student18926> studentMap = new HashMap<>();
   static{
    studentMap.put(1, new Student18926("sidhu",1    , null));
    studentMap.put(2, new Student18926("Jane Smith", 2, null));
    studentMap.put(3, new Student18926("Alice Johnson", 3, null));
   }

   //method to get student by name
   public Student18926 getStudentByName(String name) {
       for (Student18926 student : studentMap.values()) {
           if (student.getName().equals(name)) {
               return student;
           }
       }
       return null;
   }
 
   //add a new student
   public void addStudent(Student18926 student) {
       studentMap.put(student.getAge(), student);
       System.out.println("Added student: " + student.getName());
   }
   //list of students
   public Map<Integer, Student18926> getAllStudents() {
       return studentMap;
   }
  
   
}
