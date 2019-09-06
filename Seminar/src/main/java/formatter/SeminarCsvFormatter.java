package formatter;

import model.Seminar;
import model.Student;

public class SeminarCsvFormatter implements CsvFormatter<Seminar> {
    private Seminar seminar;
    private StringBuilder output;
    private char DELIMITER = ';';
    
    
    @Override public String format(Seminar seminar) {
        output = new StringBuilder();
        this.seminar = seminar;
        formatSeminar();
        formatStudents();
        return output.toString();
    }
    
    @Override public String format(Seminar seminar, char delimiter) {
        DELIMITER = delimiter;
        return this.format(seminar);
    }
    
    private void formatSeminar() {
        output.append(String.format("\"%s\"%c", seminar.course.number, DELIMITER));
        output.append(String.format("\"%s\"%c", seminar.name, DELIMITER));
        output.append(String.format("\"%s\"%c", seminar.description, DELIMITER));
        output.append(String.format("\"%s\"%c", seminar.location, DELIMITER));
        output.append(String.format("\"%s\"%n", seminar.getSeatsLeft()));
    }
    
    private void formatStudents() {
        for(Student student : seminar.getStudentsEnrolled()) {
            output.append(String.format("\"%s\"%c", student.firstName, DELIMITER ));
            output.append(String.format("\"%s\"%n", student.lastName));
        }
    }
    
}
