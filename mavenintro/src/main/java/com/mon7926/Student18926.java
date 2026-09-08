package com.mon7926;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Student18926 {
    private String name;
    private int age;
    private Address18926 address;

    // Default constructor
    public Student18926() {
    }

    // Parameterized constructor
   
    public Student18926( String name,   int age, Address18926 address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address18926 getAddress() {
        return address;
    }

    public void setAddress(Address18926 address) {
        System.out.println("Setting address: " + address);
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student18926{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
