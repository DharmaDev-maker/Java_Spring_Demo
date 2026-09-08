package com.mon7926;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Address18926 {
   
    private String state;
   
    private String city;

    // Default constructor
    public Address18926() {
    }

    // Parameterized constructor
    public Address18926(String state, String city) {
        this.state = state;
        this.city = city;
        System.out.println("Creating Address18926 with state: " + state + " and city: " + city);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address18926{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


}
