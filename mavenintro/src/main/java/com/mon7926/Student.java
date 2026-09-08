package com.mon7926;
// look we need to create a class which is encapsulating
// class with use of 
// private fields and public getter and setter methods

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// @Component 
public class Student {
     // @Value("${student.name}")//spel expression  also perfrom logic like addition
    private String name;
    //@Value("${student.age}")
    private int age;
   // @Autowired    // this is called field level injection
    private Address address;
    private List<String> hobbies;
    private Map<String, String> attributes;
    //constructor
    public Student() {
        System.out.println("Student constructor called to test constructor injection");
    }
    //parameter constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student parameterized constructor called to test constructor injection");
    }
    //to test tight coupling i want a constructor that accepts an Address object as well
      /*This is to test constructor Autowire injection for Address as well 
      1) pass it -> (@Qualifier("permaAddress") Address address) this syntx is used because when one or more bean present for the same class,
        Spring needs to know which one to inject.
      2)Autowired(required = false) what does this mean: it indicates that the dependency is optional, and if no matching bean is found
        , Spring will not throw an exception.

    what this line mean ??
    @Autowired
    public Student(@Value("sidhu") String name,@Value("20") int age, Address address) {}
    using spel we are passing values and using autowire we are injecting address 
    object into the constructor
    
     */
    @Autowired
    public Student(@Value("${student.name}") String name,@Value("${student.age}") int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
        System.out.println("Student parameterized constructor with Address called to test tight coupling");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("this setname is called used to test setter injection");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("this setAge is called used to test setter injection");
    }

    public Address getAddress() {
        return address;
    }
//    @Autowired   // this is called method setter level injection
    public void setAddress(Address address) {
        this.address = address;
        System.out.println("this setAddress is called used to test setter injection");
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
        System.out.println("this setHobbies is called used to test setter injection");
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        System.out.println("this setAttributes is called used to test setter injection");
    }
}
