package model;

import java.util.ArrayList;

public class Seminar {
    private final String name;
    private final String description;
    private Course course;
    private ArrayList<Enrollment> enrollments;
    private final String location = "Somewhere";
    private final int maxSeats = 20;
    
    public Seminar(String name, String description) {
        this.name = name;
        this.description = description;
        
        for (int i = 0; i < 10; i++) {
            enrollments.add(new Enrollment());
        }
    }
    
    public addCourse() {
        
    }
    
    public String getName() {
        return name + " - " + course.getName() + " - " + course.getNumber();
    }
    
    public String getDescription() {
        return description + " - " + course.getDescription();
    }
    
    public String getLocation() {
        return location;
    }
    
    public int getSeatsLeft(){
        return maxSeats - enrollments.size();
    }
    
    public ArrayList<String> getStudentList(){
        ArrayList<String> students = new ArrayList<String>();
        for (Enrollment enrollment : enrollments)
            students.add(enrollment.getInfo());
        return students;
    }
    
}
