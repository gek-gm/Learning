package refactoring;

public class CollapseHierarchyExample {
    
    class Employee {
        private String _name;
        private double _salary;

        public String getName() {
            return _name;
        }

        public void setName(String name) {
            _name = name;
        }

        public double getSalary() {
            return _salary;
        }

        public void setSalary(double salary) {
            _salary = salary;
        }
    }
}
