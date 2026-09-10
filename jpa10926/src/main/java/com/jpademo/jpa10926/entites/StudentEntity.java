package com.jpademo.jpa10926.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="student") 
public class StudentEntity {
  
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int stuid;
   private String name;
   private int mark;

   //default const with print 
   public StudentEntity() {
       System.out.println("Default constructor called");
   }

   //parameterized constructor
   public StudentEntity(int stuid, String name, int mark) {
       this.stuid = stuid;
       this.name = name;
       this.mark = mark;
   }

   //getters and setters
   public int getStuid() {
       return stuid;
   }

   public void setStuid(int stuid) {
       this.stuid = stuid;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public int getMark() {
       return mark;
   }

   public void setMark(int mark) {
       this.mark = mark;
   }

}
