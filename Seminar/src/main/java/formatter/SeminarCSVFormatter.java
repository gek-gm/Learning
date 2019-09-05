package formatter;

import model.Seminar;
import model.Student;

public class SeminarCSVFormatter extends SeminarFormatter{
    private final char DELIMITER = ';';
    
    public SeminarCSVFormatter(Seminar seminar) {
        super(seminar);
        
    }
    
    @Override
    public String format() {
        formatSeminar();
        formatStudents();
        return output.toString();
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
