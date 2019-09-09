import java.util.Calendar;
import java.util.Date;

/**
 * This class represents a course.
 * 
 * @author Luca Dotti
 *
 */
public class Course {
	//course's name
	private String name;
	//course's number
	private String number;
	//course's description
	private String description;
	//course's date
	private Calendar courseDate = Calendar.getInstance();
	
	/**
	 * Constructor that takes the course's name, number and description.
	 * 
	 * @param name
	 * @param number
	 * @param description
	 */
	public Course(String name, String number, String description) {
		this.name = name;
		this.number = number;
		this.description = description;
	}
	
	/**
	 * Getter for course's name.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for course's number.
	 * 
	 * @return String
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Getter for course's description.
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
	
	
	public void setStartDate(int year, int month, int day) {
        startDateTime.set(Calendar.YEAR, year);
        startDateTime.set(Calendar.MONTH, month);
        startDateTime.set(Calendar.DAY_OF_MONTH, day);
    }
    
    public void setStartTime(int hour, int minute) {
        startDateTime.set(Calendar.HOUR_OF_DAY, hour);
        startDateTime.set(Calendar.MINUTE, minute);
    }
    
    /**
     * Getter for course's start date and time.
     * 
     * @return Date
     */
    public Date getStartDateTime(){
        return startDateTime.getTime();
    }
}
