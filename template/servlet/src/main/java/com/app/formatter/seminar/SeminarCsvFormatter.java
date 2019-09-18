package com.app.formatter.seminar;

import java.text.SimpleDateFormat;

import com.app.formatter.Formatter;
import com.app.model.Seminar;
import com.app.model.Student;

public class SeminarCsvFormatter implements Formatter<Seminar> {
    private Seminar seminar;
    private StringBuilder output;
    private char DELIMITER = ';';
    
    public SeminarCsvFormatter() {
        
    }
    
    public SeminarCsvFormatter(char delimiter) {
        DELIMITER = delimiter;
    }
    
    @Override public String format(Seminar seminar) {
        output = new StringBuilder();
        this.seminar = seminar;
        formatSeminar();
        formatStudents();
        return output.toString();
    }
    
    private void formatSeminar() {
        output.append(String.format("\"%s\"%c", seminar.getCourse().getNumber(), DELIMITER));
        output.append(String.format("\"%s\"%c", seminar.getName(), DELIMITER));
        output.append(String.format("\"%s\"%c", seminar.getDescription(), DELIMITER));
        output.append(String.format("\"%s\"%c", seminar.getLocation(), DELIMITER));
        if (seminar.getCourse().getStartDate() != null)
            formatStartDate();
        output.append(String.format("\"%s\"%n", seminar.getSeatsLeft()));
    }
    
    private void formatStudents() {
        for(Student student : seminar.getStudentsEnrolled()) {
            output.append(String.format("\"%s\"%c", student.getFirstName(), DELIMITER ));
            output.append(String.format("\"%s\"%n", student.getLastName()));
        }
    }
    
    private void formatStartDate() {
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy, HH:mm").format(seminar.getCourse().getStartDate());
        output.append(String.format("\"%s\"%c", formattedDate, DELIMITER));
    }
    
}
