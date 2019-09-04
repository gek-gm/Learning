import model.Course;
import model.Seminar;
import model.Student;

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
        
    }
}
