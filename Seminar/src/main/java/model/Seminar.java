package model;

import java.util.ArrayList;

public class Seminar {
    private final String name;
    private final String description;
    private final String location;
    private Course course;
    private final ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
    private int maxSeats;
    
    public Seminar(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
        maxSeats = 20;
    }
    
    public void enrollStudent(Student student) {
        Enrollment enrollment = new Enrollment(student);
        enrollments.add(enrollment);
    }
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getMaxSeats() {
        return maxSeats;
    }
    
    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
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
