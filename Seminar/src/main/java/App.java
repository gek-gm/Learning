import java.io.File;
import java.io.IOException;

import formatter.Formatter;
import formatter.SeminarCsvFormatter;
import formatter.SeminarHtmlFormatter;
import model.Course;
import model.Seminar;
import model.Student;
import output.DataExporter;

public class App {
    public static void main(String[] args){
        
        Seminar seminar = new Seminar(
            "Atmosphere and Climate",
            "The aim of the seminar will be to analyze and, hopefully, to contribute to clarifying these debates",
            "New York"
        );
        
        Course newCourse = new Course(
            "Climate Change", 
            "12 hours course on climate change",
            12345
        );
        newCourse.setStartDate(2020, 11, 20);
        
        seminar.setCourse(newCourse);
        
        seminar.enrollStudent(new Student("Giacomo", "Colombo"));
        seminar.enrollStudent(new Student("Andrea", "Mattavelli"));
        seminar.enrollStudent(new Student("Enrico", "Mangano"));
        seminar.enrollStudent(new Student("Mattia", "Cattaneo"));
        
        System.out.println(seminar.getName());
        System.out.println(seminar.getDescription());
        System.out.println(seminar.getLocation());
        System.out.println(seminar.getSeatsLeft());
        System.out.println(seminar.getStudentList());
        
        File csvFile;
        Formatter<Seminar> csvConverter = new SeminarCsvFormatter();
        DataExporter<Seminar, Formatter<Seminar>> seminarExporter = new DataExporter<>(seminar, csvConverter);
        try {
            csvFile = seminarExporter.exportTo(seminar.getCourse().getName() + ".csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(csvFile.toString());
        
        Formatter<Seminar> formatter = new SeminarHtmlFormatter();
        System.out.println(formatter.format(seminar));
        
    }
}
