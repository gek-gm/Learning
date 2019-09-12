package refactoring;

import java.util.HashSet;
import java.util.Set;

public class EncapsulateCollectionExample {
    
    public void clientCode() {
        Person kent = new Person();
        Set<Course> s = new HashSet<>();
        s.add(new Course ("Smalltalk Programming", false));
        s.add(new Course ("Appreciating Single Malts", true));
        kent.setCourses(s);
        Course refact = new Course ("Refactoring", true);
        kent.getCourses().add(refact);
        kent.getCourses().add(new Course ("Brutal Sarcasm", false));
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
        private Set<Course> _courses;
        
        public Set<Course> getCourses() {
            return _courses;
        }
        public void setCourses(Set<Course> arg) {
            _courses = arg;
        }
    }
    
}
