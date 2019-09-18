package com.app.model;

import java.util.Date;

public class Enrollment {
    private final Student _student;
    private final Date _enrollmentDate;

    public Enrollment(Student student) {
        this._student = student;
        _enrollmentDate = new Date();
    }

    public Student getStudent() {
        return _student;
    }

    public String getInfo() {
        return _student.getInfo();   
    }
    
    public Date getEnrollmentDate() {
        return _enrollmentDate;
    }
    
}
