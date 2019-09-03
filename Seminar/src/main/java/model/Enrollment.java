package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Enrollment {
    Student student;
    Date enrollmentDate;
    
    public Enrollment(Student student) {
        this.student = student;
        enrollmentDate = new Date();
    }
    
    public Student getStudent() {
        return student;
    }

    public Date getDate() {
        return enrollmentDate;
    }

    public String getInfo() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return student.getInfo() + " ' " + format.format(enrollmentDate); 
    }
    
}
