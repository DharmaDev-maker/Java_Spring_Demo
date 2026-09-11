package com.practice.student_mange.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY  )
    private Long id;
    private String email;
    private String name;
    private String dob;

    //default constructor with print
    public Student() {
    }
    //para const with print
    public Student( String email, String name, String dob) {
        this.email = email;
        this.name = name;
        this.dob = dob;
    }
    //getter and setter with print
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
