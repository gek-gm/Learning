package refactoring;

public class ReplaceDelegationWithInheritanceExample {
    
    class Employee extends Person{
        
        @Override
        public String toString () {
            return "Emp: " + getLastName();
        }
    }
    
    class Person {
        String _name;
        
        public String getName() {
            return _name;
        }
        public void setName(String arg) {
            _name = arg;
        }
        public String getLastName() {
            return _name.substring(_name.lastIndexOf(' ')+1);
        }
    }
}
