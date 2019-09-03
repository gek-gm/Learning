package model;

public class Course {
    private final String name;
    private final int number;
    private final String description;
    
    public Course(String name, String description, int number) {
        this.name = name;
        this.description = description;
        this.number = number;
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumber() {
        return number;
    }
    
    public String getDescription() {
        return description;
    }
    
}
