package refactoring;

public class ReplaceConditionalWithPolymorphismExample {
    
    class Employee {
        private EmployeeType _type;
        private int _monthlySalary;
        private int _commission;
        private int _bonus;
        
        public int getMonthlySalary() {
            return _monthlySalary;
        }

        public void setMonthlySalary(int monthlySalary) {
            _monthlySalary = monthlySalary;
        }

        public int getCommission() {
            return _commission;
        }

        public void setCommission(int commission) {
            _commission = commission;
        }

        public int getBonus() {
            return _bonus;
        }

        public void setBonus(int bonus) {
            _bonus = bonus;
        }

        public Employee (int employeeTypeCode) {
            setType(employeeTypeCode);
        }
        
        public void setType(int typeCode) {
            _type = EmployeeType.createType(typeCode);
        }
        
        int payAmount() {
            return _type.payAmount(this);
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
        
        abstract int payAmount(Employee employee);
    }
    
    static class Engineer extends EmployeeType {
        
        @Override
        public int payAmount(Employee employee) {
            return employee.getMonthlySalary();
        }
    }
    
    static class Manager extends EmployeeType {
        
        @Override
        public int payAmount(Employee employee) {
            return employee.getMonthlySalary() + employee.getBonus();
        }
    }
    
    static class SalesMan extends EmployeeType {
        
        @Override
        public int payAmount(Employee employee) {
            return employee.getMonthlySalary() + employee.getCommission();
        }
    }
}
