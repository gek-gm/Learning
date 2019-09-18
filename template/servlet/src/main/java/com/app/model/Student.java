package com.app.model;

public class Student {
    private final String firstName;
    private final String lastName;
    
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName; 
    }
    
    public String getInfo() {
        return this.getFullName();
    }
    
}
