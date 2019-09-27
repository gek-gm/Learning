package com.app.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Course {
    private final String _name;
    private int _number;
    private String _description;
    private final String _location;
    private final int _maxSeats;
    private final Calendar _startDate = Calendar.getInstance();
    
    public Course(String name, String location, int maxSeats, Date startDate) {
        _name = name;
        _location = location;
        _maxSeats = maxSeats;
        _startDate.setTime(startDate);   
    }
    
    public String getName() {
        return _name;
    }

    public int getNumber() {
        return _number;
    }

    public void setNumber(int number) {
        if (number > _maxSeats)
            throw new RuntimeException("Number can't be greater than max seats available");
        _number = number;
    }

    public String getDescription() {
        return _description;
    }
    
    public void setDescription(String description) {
        _description = description;
    }
    
    public String getLocation() {
        return _location;
    }

    public int getMaxSeats() {
        return _maxSeats;
    }
    
    public Date getStartDate(){
        return _startDate != null ? _startDate.getTime() : null;
    }
    
    public String getStartDateAsString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
        return formatter.format(_startDate.getTime());
    }
}
