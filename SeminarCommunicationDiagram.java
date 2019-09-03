import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;


public class SeminarCommunicationDiagram{
    
    public static void main(String... args) {
        System.out.println("Hello world");
    }
    
}

class Seminar {
    private String name = "Sample Seminar";
    private String description = "Just a sample description";
    private Course course = new Course();
    private ArrayList<Enrollment> enrollments = new ArrayList<>(); 
    private String location = "Somewhere";
    private int maxSeats = 20;
    
    public Seminar() {
        for (int i = 0; i < 10; i++) {
            enrollments.add(new Enrollment());
        }
    }
    
    public String getName() {
        return name + " - " + course.getName() + " - " + course.getNumber();
    }
    
    public String getDescription() {
        return description + " - " + course.getDescription();
    }
    
    public String getLocation() {
        return location;
    }
    
    public int getSeatsLeft(){
        return maxSeats - enrollments.size();
    }
    
    public ArrayList<String> getStudentList(){
        ArrayList<String> students = new ArrayList<>();
        for (Enrollment enrollment : enrollments)
            students.add(enrollment.getInfo());
        return students;
    }
}

class Course {
    private String name = "Sample Course";
    private int number = 12345;
    private String description = "Course Description";
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}

class Enrollment {
    Student student = new Student();
    Date date = new Date();
    
    public String getInfo() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return student.getInfo() + " ' " + format.format(date);
    }
    
}

class Student {
    private String firstName = "Sample";
    private String lastName = "Student";
    
    public String getFullName() {
        return firstName + " " + lastName; 
    }
    
    public String getInfo() {
        return this.getFullName();
    }
    
}

