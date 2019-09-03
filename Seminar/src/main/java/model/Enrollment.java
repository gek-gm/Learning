package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Enrollment {
    Student student;
    Date date = new Date();
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInfo() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return student.getInfo() + " ' " + format.format(date); 
    }
    
}
