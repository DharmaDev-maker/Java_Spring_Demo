package com.mon7926.service;

import com.mon7926.Student;
import com.mon7926.dao.StudentDAOImpl;

//used to manager the exceptions , and provide service layer logic for student operations
//provides the core logic or bussiness logic
public class StudentserviceImpl {
  
    StudentDAOImpl s;

    //getStudentByName,addStudent this methods deal with database 
    public void printStudentByName(String name) {
        System.out.println(s.getStudentByName(name));
    }
    
    public void addStudent(Student student) {
        s.addStudent(student);
    }
  

}
