import static org.junit.Assert.*;

import org.junit.Test;

import model.Seminar;
import model.Student;

public class SeminarTest {

    @Test
    public void whenStudentIsEnrolled_seatsLeftDecrease() {
        Seminar seminar = new Seminar("This","is","test");
        seminar.setMaxSeats(10);
        int seatsBeforeEnrollment = seminar.getSeatsLeft();
        seminar.enrollStudent(new Student("Giacomo","Colombo"));
        int seatsAfterEnrollment = seminar.getSeatsLeft();
        assertEquals(seatsBeforeEnrollment - 1, seatsAfterEnrollment);
    }
    
    @Test(expected = RuntimeException.class)
    public void whenMaxSeatsIsReached_studentNotAdded(){
        Seminar seminar = new Seminar("This","is","test");
        int seatsLeft = seminar.getSeatsLeft();
        for (int i = 0; i < seatsLeft; i++)
            seminar.enrollStudent(new Student("Test","Student " + i));
        seminar.enrollStudent(new Student("Giacomo","Colombo"));
    }

}
