package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Enrollment {
    public final Student student;
    public final Date enrollmentDate;
    
    public Enrollment(Student student) {
        this.student = student;
        enrollmentDate = new Date();
    }

    public String getInfo() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return student.getInfo() + " ' " + format.format(enrollmentDate); 
    }
    
}
