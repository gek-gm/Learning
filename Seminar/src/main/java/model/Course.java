package model;

import java.util.Calendar;
import java.util.Date;

public class Course {
    private final String _name;
    private final int _number;
    private final String _description;
    private Calendar _startDate;
    
    public Course(String name, String description, int number) {
        this._name = name;
        this._description = description;
        this._number = number;
    }
    
    public void setStartDate(int year, int month, int day) {
        _startDate = Calendar.getInstance();
        _startDate.set(Calendar.YEAR, year);
        _startDate.set(Calendar.MONTH, month);
        _startDate.set(Calendar.DAY_OF_MONTH, day);
    }
    
    public String getName() {
        return _name;
    }

    public int getNumber() {
        return _number;
    }

    public String getDescription() {
        return _description;
    }
    
    public Date getStartDate(){
        return _startDate != null ? _startDate.getTime() : null;
    }
    
}
