import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import formatter.Formatter;
import formatter.SeminarCsvFormatter;
import formatter.SeminarHtmlFormatter;
import model.Course;
import model.Seminar;
import model.Student;
import output.DataExporter;

public class SeminarTest {
    private Seminar seminar;
    
    @Before
    public void setUpSeminar() {
        seminar = new Seminar(
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
    }
    
    private void enrollStudents(int howMany){
        for (int i = 0; i < howMany; i++)
            seminar.enrollStudent(new Student("Test","Student " + i));
    }
    
    private void enrollForComplianceTests() {
        seminar.enrollStudent(new Student("Giacomo", "Colombo"));
        seminar.enrollStudent(new Student("Andrea", "Mattavelli"));
        seminar.enrollStudent(new Student("Enrico", "Mangano"));
        seminar.enrollStudent(new Student("Mattia", "Cattaneo"));
    }
    

    @Test
    public void whenStudentIsEnrolled_expectSeatsLeftDecrease() {
        int seatsBeforeEnrollment = seminar.getSeatsLeft();
        seminar.enrollStudent(new Student("Giacomo","Colombo"));
        int seatsAfterEnrollment = seminar.getSeatsLeft();
        assertEquals(seatsBeforeEnrollment - 1, seatsAfterEnrollment);
    }
    
    @Test(expected = RuntimeException.class)
    public void whenMaxSeatsIsReached_expectStudentNotAdded(){
        enrollStudents(seminar.getSeatsLeft());
        seminar.enrollStudent(new Student("Giacomo","Colombo"));
    }
    
    @Test
    public void whenCsvExportisTriggered_expectFileWithRightNameIsCreated() throws IOException{
        enrollStudents(seminar.getSeatsLeft());
        Formatter<Seminar> csvFormatter = new SeminarCsvFormatter();
        DataExporter<Seminar, Formatter<Seminar>> seminarExporter = new DataExporter<>(seminar, csvFormatter);
        
        File csvFile = seminarExporter.exportTo(seminar.getCourse().getName() + ".csv");
        
        assertTrue(csvFile.exists());
        assertEquals(csvFile.getName(), seminar.getCourse().getName() + ".csv");
    }
    
    @Test
    public void whenCsvExportisTriggered_expectFileContentIsCompliant() throws IOException{
        enrollForComplianceTests();
        Formatter<Seminar> csvFormatter = new SeminarCsvFormatter();
        DataExporter<Seminar, Formatter<Seminar>> seminarExporter = new DataExporter<>(seminar, csvFormatter);
        
        File csvFile = seminarExporter.exportTo(seminar.getCourse().getName() + ".csv");
        
        File testFile = new File(this.getClass().getResource("file_structure_compliance.csv").getFile());
        assertTrue("The files differ!", FileUtils.contentEquals(testFile, csvFile));
    }
    
    @Test
    public void whenSeminarIsFormattedAsHtml_expectStructureIsCompliant() throws IOException{
        enrollForComplianceTests();
        String htmlFormat = new String(
            Files.readAllBytes(
                Paths.get(this.getClass().getResource("seminar_html_structure_compliance.html").getFile())
            ));
        Formatter<Seminar> seminarFormatter = new SeminarHtmlFormatter();
        
        String seminarHtml = seminarFormatter.format(seminar);
        System.out.print(seminarHtml);
        assertEquals(htmlFormat, seminarHtml);
    }
    
}
