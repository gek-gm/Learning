package model;

public class Student {
    public final String firstName;
    public final String lastName;
    
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName; 
    }
    
    public String getInfo() {
        return this.getFullName();
    }
    
}
