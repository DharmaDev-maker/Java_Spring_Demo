package com.practice.student_mange.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "enrollment_table")

public class Enrollment {
          @Id
          @GeneratedValue( strategy= GenerationType.IDENTITY  )
          private Long id;
          private String enrollmentDate;

          //default constructor with print
          public Enrollment() {
          }
          //parameterized constructor with print
          public Enrollment(String enrollmentDate) {
              this.enrollmentDate = enrollmentDate;
          }
          //getter and setter with print
          public Long getId() {
              return id;
          }

          public void setId(Long id) {
              this.id = id;
          }

          public String getEnrollmentDate() {
              return enrollmentDate;
          }

          public void setEnrollmentDate(String enrollmentDate) {
              this.enrollmentDate = enrollmentDate;
          }
}
