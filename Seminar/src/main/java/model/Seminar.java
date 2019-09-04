package model;

import java.util.ArrayList;

public class Seminar {
    public final String name;
    public final String description;
    public final String location;
    public Course course;
    public final ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
    private int maxSeats;
    
    public Seminar(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
        maxSeats = 20;
    }
    
    public void enrollStudent(Student student) {
        if (enrollments.size() == maxSeats)
            throw new RuntimeException("This Seminar is fully booked");
        
        Enrollment enrollment = new Enrollment(student);
        enrollments.add(enrollment);
    }
    
    public boolean isFullyBooked() {
        return maxSeats - enrollments.size() == 0;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public String getName() {
        return name + " - " + course.name + " - " + course.number;
    }
    
    public String getDescription() {
        return description + " - " + course.description;
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
