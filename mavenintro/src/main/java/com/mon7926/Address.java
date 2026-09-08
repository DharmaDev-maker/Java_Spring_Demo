package com.mon7926;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component 
public class Address {
  
    //@Value("Springfield_testing_spel") //spel expression
    //@Value("${city}") // this is place holder and internally it treats as string value for this 
    //for this reason we will use annotation called context:property-placeholder we will pass the data from 
    //additonfile.properties like some example file and we will pass: city=Springfield
    @Value("${address.city}")
    private String city;
    
    @Value("${address.state}")
    private String state;
   //constructor
    public Address() {
        System.out.println("Address constructor called");
    }
    //parameterized constructor
    public Address(String city, String state) {
        this.city = city;
        this.state = state;
        System.out.println("Address parameterized constructor called");
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        System.out.println("for testing address setter for state");

        this.state = state ;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        System.out.println("for testing address setter for city");

        this.city = city;
    }
    //toString method
    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

  

}
