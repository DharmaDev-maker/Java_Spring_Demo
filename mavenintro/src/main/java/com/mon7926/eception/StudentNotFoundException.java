package com.mon7926.eception;
/*
   why runtime exception why not exception ?

*/
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }

}
