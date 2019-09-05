package model;

import java.util.Date;

public class Enrollment {
    public final Student student;
    public final Date enrollmentDate;
    
    public Enrollment(Student student) {
        this.student = student;
        enrollmentDate = new Date();
        
    }

    public String getInfo() {
        return student.getInfo();
        
    }
    
}
