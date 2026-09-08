package com.mon7926.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mon7926.Address;
import com.mon7926.Address18926;
import com.mon7926.Student18926;

@Configuration //Indicates that this class 
// contains Spring configuration and bean definitions
//another java way of creating beans instead of xml   wat diff btw cofigurable and configuration
public class SpringConfig {

     @Bean //if we not specify the bean the it will not work
     public Address18926 getAddress( ) {
        return new Address18926("defaultState","defaultCity"); // create Address bean with default constructor
       
        
     }

     //@import,@importResorces()
     //wha does this internally mean
     // object creation
     // s.setter
     //what does getStudent(Address18926 address) mean
     // it means that Spring will automatic"ally inject the Address18926 bean into this method when creating the Student18926 bean
      @Bean
     public Student18926 getStudent() {
        return new Student18926("defaultName", 18, getAddress()); // create Student bean with default values and inject Address bean
     }
}
