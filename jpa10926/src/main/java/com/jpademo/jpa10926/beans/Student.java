package com.jpademo.jpa10926.beans;

public class Student {
  
   private int stuid;
   private String name;
   private int mark;

   //default const with print 
   public Student() {
       System.out.println("Default constructor called");
   }

   //parameterized constructor
   public Student(int stuid, String name, int mark) {
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
