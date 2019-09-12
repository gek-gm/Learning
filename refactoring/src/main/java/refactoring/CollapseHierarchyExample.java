package refactoring;

public class CollapseHierarchyExample {
    
    class Employee {
        private String _name;

        public String getName() {
            return _name;
        }

        public void setName(String name) {
            _name = name;
        }
    }
    
    class SalesMan extends Employee {
        private double _salary;

        public double getSalary() {
            return _salary;
        }

        public void setSalary(double salary) {
            _salary = salary;
        }
    }
}
