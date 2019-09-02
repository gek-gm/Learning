package com.gmail.gcmcolombo.model;

public class Participant implements Person{
    private String firstName;
    private String lastName;
    private Boolean absent;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean isAbsent() {
        return absent;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAbsent(Boolean absent) {
        this.absent = absent;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
