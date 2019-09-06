import java.io.File;
import java.io.IOException;

import formatter.CsvFormatter;
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
        
        seminar.setCourse(newCourse);
        
        seminar.enrollStudent(new Student("Giacomo", "Colombo"));
        seminar.enrollStudent(new Student("Andrea", "Mattavelli"));
        seminar.enrollStudent(new Student("Enrico", "Mangano"));
        seminar.enrollStudent(new Student("Mattia", "Cattaneo"));
        
        System.out.println(seminar.getName());
        System.out.println(seminar.getDescription());
        System.out.println(seminar.location);
        System.out.println(seminar.getSeatsLeft());
        System.out.println(seminar.getStudentList());
        
        File csvFile;
        CsvFormatter<Seminar> csvConverter = new SeminarCsvFormatter();
        DataExporter<Seminar, CsvFormatter<Seminar>> seminarExporter = new DataExporter<>(seminar, csvConverter);
        try {
            csvFile = seminarExporter.exportTo(seminar.course.name + ".csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(csvFile.toString());
        
        Formatter<Seminar> formatter = new SeminarHtmlFormatter();
        System.out.println(formatter.format(seminar));
        
        
    }
}
