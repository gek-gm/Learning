package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Seminar {
    private final String _name;
    private final String _description;
    private final String _location;
    private final Collection<Enrollment> _enrollments = new ArrayList<>();
    private Course _course;
    private int _maxSeats;
    
    public Seminar(String name, String description, String location) {
        this._name = name;
        this._description = description;
        this._location = location;
        _maxSeats = 20;
        
    }
    
    public String getLocation() {
        return _location;
    }
    
    public Collection<Enrollment> getEnrollments() {
        return _enrollments;
    }

    public Course getCourse() {
        return _course;
    }

    public int getMaxSeats() {
        return _maxSeats;
    }

    public void enrollStudent(Student student) {
        if (_enrollments.size() == _maxSeats)
            throw new RuntimeException("This Seminar is fully booked");
        
        Enrollment enrollment = new Enrollment(student);
        _enrollments.add(enrollment);
        
    }
    
    public boolean isFullyBooked() {
        return _maxSeats - _enrollments.size() == 0;
        
    }

    public void setCourse(Course course) {
        this._course = course;
        
    }
    
    public void setMaxSeats(int maxSeats) {
        if (maxSeats < _enrollments.size())
            throw new IllegalArgumentException("Seminar Max Seats attribute cannot be lower than students already enrolled");
        this._maxSeats = maxSeats;
        
    }

    public String getName() {
        return _name + " - " + _course.getName() + " - " + _course.getNumber();
        
    }
    
    public String getDescription() {
        return _description + " - " + _course.getDescription();
        
    }
    
    public int getSeatsLeft(){
        return _maxSeats - _enrollments.size();
        
    }
    
    public List<String> getStudentList(){
        List<String> studentsName = new ArrayList<>();
        for (Enrollment enrollment : _enrollments)
            studentsName.add(enrollment.getInfo());
        return studentsName;
        
    }
    
    public List<Student> getStudentsEnrolled(){
        List<Student> studentsEnrolled = new ArrayList<>();
        for (Enrollment enrollment : _enrollments)
            studentsEnrolled.add(enrollment.getStudent());
        return studentsEnrolled;
        
    }
}
