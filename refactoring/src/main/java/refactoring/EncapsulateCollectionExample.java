package refactoring;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EncapsulateCollectionExample {
    
    public void clientCode() {
        Person kent = new Person();
        kent.addCourse(new Course ("Smalltalk Programming", false));
        kent.addCourse(new Course ("Appreciating Single Malts", true));
        kent.addCourse(new Course ("Brutal Sarcasm", false));
        for(Course course : kent.getCourses())
            System.out.println(course.getName());
        
    }
    
    class Course {
        private final String _name;
        private final boolean _isAdvanced;
        
        public Course (String name, boolean isAdvanced) {
            _name = name;
            _isAdvanced = isAdvanced;
        }
        
        public boolean isAdvanced() {
            return _isAdvanced;
        }
        
        public String getName() {
            return _name;
        }
    }
    
    class Person {
        private final Set<Course> _courses = new HashSet<>();
        
        public Set<Course> getCourses() {
            return Collections.unmodifiableSet(_courses);
        }
        
        public void addCourse(Course aCourse) {
            _courses.add(aCourse);
        }
    }
    
}
