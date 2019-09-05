package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import formatter.SeminarCSVFormatter;
import formatter.SeminarFormatter;
import formatter.SeminarHTMLFormatter;

public class Seminar {
    public final String name;
    public final String description;
    public final String location;
    public Course course;
    public final Collection<Enrollment> enrollments = new ArrayList<>();
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
        if (maxSeats < enrollments.size())
            throw new IllegalArgumentException("Seminar Max Seats attribute cannot be lower than students already enrolled");
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
    
    public List<String> getStudentList(){
        List<String> studentsName = new ArrayList<>();
        for (Enrollment enrollment : enrollments)
            studentsName.add(enrollment.getInfo());
        return studentsName;
        
    }
    
    public List<Student> getStudentsEnrolled(){
        List<Student> studentsEnrolled = new ArrayList<>();
        for (Enrollment enrollment : enrollments)
            studentsEnrolled.add(enrollment.student);
        return studentsEnrolled;
        
    }
    
    public String toHtml() {
        SeminarFormatter formatter = new SeminarHTMLFormatter(this);
        return formatter.format();
    }
    
    public File toCsv() throws IOException {
        SeminarFormatter formatter = new SeminarCSVFormatter(this);
        File csvFile = new File(this.course.name + ".csv");
        try ( FileWriter fw = new FileWriter(csvFile)) { 
            fw.write(formatter.format());
        }
        return csvFile;        
    }
    
}
