package refactoring;

public class ReplaceConditionalWithPolymorphismExample {
    
    class Employee {
        private EmployeeType _type;
        
        public Employee (int employeeTypeCode) {
            setType(employeeTypeCode);
        }
        
        public void setType(int typeCode) {
            _type = EmployeeType.createType(typeCode);
        }
        
        int payAmount() {
            return _type.payAmount();
        }
    }
    
    static abstract class EmployeeType{
        static final int ENGINEER = 0;
        static final int SALESMAN = 1;
        static final int MANAGER = 2;
        
        public static EmployeeType createType(int type) {
            switch(type) {
                case ENGINEER:
                    return new Engineer();
                case SALESMAN:
                    return new SalesMan();
                case MANAGER:
                    return new Manager();
                default:
                    throw new IllegalArgumentException("Incorrect employee code type");
            }
        }
        
        abstract int payAmount();
    }
    
    static class Engineer extends EmployeeType {
        private final int _monthlySalary;
        
        public Engineer() {
            _monthlySalary = 199;
        }
        
        @Override
        public int payAmount() {
            return _monthlySalary;
        }
    }
    
    static class Manager extends EmployeeType {
        private final int _monthlySalary;
        private final int _bonus;
        
        public Manager() {
            _monthlySalary = 500;
            _bonus = 1000;
        }
        
        @Override
        public int payAmount() {
            return _monthlySalary + _bonus;
        }
    }
    
    static class SalesMan extends EmployeeType {
        private final int _monthlySalary;
        private final int _commission;
        
        public SalesMan() {
            _monthlySalary = 1000;
            _commission = 100;
        }
        
        @Override
        public int payAmount() {
            return _monthlySalary + _commission;
        }
    }
}
