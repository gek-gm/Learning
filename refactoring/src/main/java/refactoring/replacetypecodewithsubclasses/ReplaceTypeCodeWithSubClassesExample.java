package refactoring.replacetypecodewithsubclasses;

public class ReplaceTypeCodeWithSubClassesExample {
    
    static abstract class Employee{
        static final int ENGINEER = 0;
        static final int SALESMAN = 1;
        static final int MANAGER = 2;
        
        public static Employee create(int type) {
            switch(type) {
                case ENGINEER:
                    return new Engineer();
                case SALESMAN:
                    return new Salesman();
                case MANAGER:
                    return new Manager();
                default:
                    throw new IllegalArgumentException("Incorrect Type Value");
            }
        }
        
        abstract int getType();
    }
    
    static class Engineer extends Employee {
        @Override
        int getType() {
            return Employee.ENGINEER;
        }
    }
    static class Salesman extends Employee {
        @Override
        int getType() {
            return Employee.SALESMAN;
        }
    }
    static class Manager extends Employee {
        @Override
        int getType() {
            return Employee.MANAGER;
        }
    }

}
