package com.app.formatter.seminar;

import java.text.SimpleDateFormat;

import com.app.formatter.Formatter;
import com.app.model.Seminar;

public class SeminarRawFormatter implements Formatter<Seminar> {
    private StringBuilder _output;
    private Seminar _seminar;
    
    @Override
    public String format(Seminar seminar){
        _seminar = seminar;
        _output = new StringBuilder();
        formatSeminarDetails();
        formatStudentsList();
        return _output.toString();
    }
    
    private void formatSeminarDetails() {
        _output.append(String.format("Name: %s%n", _seminar.getName()));
        _output.append(String.format("Description: %s%n", _seminar.getDescription()));
        _output.append(String.format("Location: %s%n", _seminar.getLocation() ));
        formatSeminarDate();
        _output.append(String.format("Seats Left: %s%n", _seminar.getSeatsLeft() ));
    }
    
    private void formatStudentsList() {
        _output.append("Participants:");
        for (String studentName : _seminar.getStudentList())
            _output.append(String.format("%s%n", studentName));
    }
    
    private void formatSeminarDate() {
        if(_seminar.getCourse().getStartDate() != null ) {
            String formattedDate = new SimpleDateFormat("dd/MM/yyyy, HH:mm").format(_seminar.getCourse().getStartDate());
            _output.append(String.format("Date: %s%n", formattedDate));   
        }
    }

}
