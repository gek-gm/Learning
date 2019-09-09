package model;

import java.util.Calendar;
import java.util.Date;

public class Course {
    public final String name;
    public final int number;
    public final String description;
    private Calendar startDate;
    
    public Course(String name, String description, int number) {
        this.name = name;
        this.description = description;
        this.number = number;
        
    }
    
    public void setStartDate(int year, int month, int day) {
        startDate = Calendar.getInstance();
        startDate.set(Calendar.YEAR, year);
        startDate.set(Calendar.MONTH, month);
        startDate.set(Calendar.DAY_OF_MONTH, day);
    }
    
    public Date getStartDate(){
        return startDate != null ? startDate.getTime() : null;
    }
    
}
